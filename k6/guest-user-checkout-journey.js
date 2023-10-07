import { check, group, sleep, fail } from 'k6';
import { Rate } from 'k6/metrics';
import http from 'k6/http';
import { Trend } from 'k6/metrics';
import { uuidv4 } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

const baseUrl = 'https://jf-frontshop-service-platform-sit2.loblaw.digital/ca/api';

const products = JSON.parse(open('test-data/products.json'));
const users = JSON.parse(open('test-data/users.json'));
const vouchers = JSON.parse(open('test-data/vouchers.json'));

//Transaction Metrics
const createCartAPITrend = new Trend('POST /cart/createCart Create Cart API ');
const addCartEntryAPITrend = new Trend('POST /cart/addEntry Add to Cart API ');
const fetchCartBasicAPITrend = new Trend(
	'GET /cart/fetchCart Fetch Cart API (Basic) '
);
const fetchCartDefaultAPITrend = new Trend(
	'GET /cart/fetchCart Fetch Cart API (Full) '
);
const validateCartAPITrend = new Trend(
	'POST /cart/validateCart Validate Cart API '
);
const assignEmailAPITrend = new Trend(
	'PUT /cart/assignEmail Assign Email Guest Customer API '
);
const createShippingAddressAPITrend = new Trend(
	'POST /checkout/createShippingAddress Create Shipping Address API '
);
const getShippingOptionsAPITrend = new Trend(
	'GET /checkout/getShippingOptions Get Shipping Options API '
);
const setShippingMethodAPITrend = new Trend(
	'PUT /checkout/setShippingOption Set Delivery Method in Cart API '
);
const handleGPResponseAPITrend = new Trend(
	'POST /checkout/handleGlobalPaymentResponse Handle GP Response API '
);
const placeOrderAPITrend = new Trend(
	'POST /checkout/placeGPOrder Place Order API'
);
const addVoucherAPITrend = new Trend('POST /cart/addVoucher Add Voucher API');
const removeVoucherAPITrend = new Trend(
	'DELETE /cart/removeVoucher Remove Voucher API'
);
const saveCreditCardAPITrend = new Trend(
	'POST /payment/saveCard Save Credit Card API '
);

/*
 * Add to cart User journey
 */
export function guestUserCheckoutJourney() {
	const globalOptions = {
		cookies: {
			Origin_Session_Cookie: 'B',
		},
		headers: {
			'Content-Type': 'application/json',
			// 'cookie': 'gukOkYU4-uVqLsNONMeVWvMC7tcodau6byxM',
		},
	};
	let voucher = vouchers[Math.floor(Math.random() * vouchers.length)];
	/**
	 * Check if we can use multiple data points
	 * Use faker maybe
	 */

	let userId = 'anonymous';

	group('Guest Checkout User Journey ', (_) => {
		let product = products[Math.floor(Math.random() * products.length)];
		let user = users[Math.floor(Math.random() * users.length)];

		// Create cart
		const createCart_response = httpPost(
			`${baseUrl}/cart/createCart?userId=${userId}&fields=BASIC`,
			undefined,
			globalOptions,
			201
		);

		createCartAPITrend.add(createCart_response.timings.duration);

		let cartId;
		check(createCart_response, {
			'Create cart response success  ': (r) => r.status === 201,
			'Create cart response has cart guid ': (r) => r.json().guid != undefined,
		});

		cartId = createCart_response.json().guid;

		let payload = JSON.stringify({
			product: {
				code: product.id,
			},
			quantity: product.qty,
		});
		// Add entry to cart

		const addEntry_response = httpPost(
			`${baseUrl}/cart/addEntry?userId=${userId}&cartId=${cartId}&fields=BASIC`,
			payload,
			globalOptions,
			200
		);

		addCartEntryAPITrend.add(addEntry_response.timings.duration);
		check(addEntry_response, {
			'Add to cart response success  ': (r) => r.status === 200,
		});

		const fetchCartBasic_response = httpGet(
			`${baseUrl}/cart/fetchCart?userId=${userId}&fields=BASIC&cartId=${cartId}`,
			globalOptions,
			200
		);

		fetchCartBasicAPITrend.add(fetchCartBasic_response.timings.duration);

		let quan = product.qty;

		check(fetchCartBasic_response, {
			'Fetch cart basic response success  ': (r) => r.status === 200,
			'Fetch cart basic response unit count match ': (r) =>
				r.json().totalUnitCount === 1,
		});

		// fetch cart check the Entry to be present
		const fetchCartDefault_response = httpGet(
			`${baseUrl}/cart/fetchCart?userId=${userId}&fields=DEFAULT&cartId=${cartId}`,
			globalOptions,
			200
		);

		fetchCartDefaultAPITrend.add(fetchCartBasic_response.timings.duration);

		check(fetchCartDefault_response, {
			'Fetch cart default response success  ': (r) => r.status === 200,
			'Fetch cart default response unit count match ': (r) =>
				r.json().totalUnitCount === 1,
		});

		const validateCart_response = httpPost(
			`${baseUrl}/cart/validateCart?userId=${userId}&cartId=${cartId}`,
			undefined,
			globalOptions,
			202
		);

		validateCartAPITrend.add(validateCart_response.timings.duration);

		check(validateCart_response, {
			'Validate cart default response success  ': (r) => r.status === 202,
			'Validate cart default response unit count match ': (r) =>
				r.json().totalUnitCount === 1,
		});

		// Assign email
		// https://jf-frontshop-service-dev.loblaw.digital/api/cart/assignEmail?userId=${userId}&cartId=822b61fd-7aa2-46cf-8154-1ba8857e5553&email=abc22%40yopmail.com

		let guestUserId, customerID;
		let email = user.email;
		const assignEmail_response = httpPut(
			`${baseUrl}/cart/assignEmail?userId=${userId}&email=${email}&cartId=${cartId}`,
			undefined,
			globalOptions,
			200
		);

		assignEmailAPITrend.add(assignEmail_response.timings.duration);

		check(assignEmail_response, {
			'Assign email response success  ': (r) => r.status === 200,
			'has guestUID in response ': (r) => r.json().guestUID != undefined,
			'has customerID in response ': (r) => r.json().customerID != undefined,
		});
		guestUserId = encodeURIComponent(assignEmail_response.json().guestUID);
		customerID = encodeURIComponent(assignEmail_response.json().customerID);
		console.log('guestUserId  ::customerID :: ', guestUserId, customerID);

		//Add Voucher
		let voucherId = voucher.id;
		const addVoucher_response = httpPost(
			`${baseUrl}/cart/addVoucher?userId=${customerID}&cartId=${cartId}&voucherId=${voucherId}&fields=BASIC`,
			undefined,
			globalOptions,
			200
		);

		addVoucherAPITrend.add(addVoucher_response.timings.duration);
		check(addVoucher_response, {
			'Add Voucher API response success > ': (r) => r.status === 200,
		});


		const removeVoucher_response = httpDelete(
			`${baseUrl}/cart/removeVoucher?userId=${customerID}&cartId=${cartId}&voucherId=${voucherId}&fields=BASIC`,
			undefined,
			globalOptions,
			200
		);

		removeVoucherAPITrend.add(removeVoucher_response.timings.duration);
		check(removeVoucher_response, {
			'Remove Voucher API response success > ': (r) => r.status === 200,
		});

		// Create shipping Address
		// https://jf-frontshop-service-dev.loblaw.digital/api/checkout/createShippingAddress?userId=60dc4fc3-64ff-4999-8a5b-07d39135dbc2%7Cabc22%40yopmail.com&cartId=651000117237889

		let shippingAddress_payload = JSON.stringify(user.address);

		// this request uses cartCode?
		console.log(guestUserId)
		console.log(cartId)
		const createShippingAddress_response = httpPost(
			`${baseUrl}/checkout/createShippingAddress?userId=${customerID}&cartId=${cartId}`,
			shippingAddress_payload,
			globalOptions,
			201
		);

		createShippingAddressAPITrend.add(
			createShippingAddress_response.timings.duration
		);

		check(createShippingAddress_response, {
			'Create shipping response success  ': (r) => r.status === 201,
		});

		// Get shipping options
		// https://jf-frontshop-service-dev.loblaw.digital/api/checkout/getShippingOptions?userId=373aa805-84fc-4482-b227-4e328fb0fa02|pcidtest@yopmail.com&cartId=651000117239920&fields=FULL
		const getShippingOptions_response = httpGet(
			`${baseUrl}/checkout/getShippingOptions?userId=${customerID}&cartId=${cartId}&fields=FULL`,
			globalOptions,
			200
		);

		getShippingOptionsAPITrend.add(
			getShippingOptions_response.timings.duration
		);

		check(getShippingOptions_response, {
			'Get shipping options success  ': (r) => r.status === 200,
			'Get shipping options success  ': (r) =>
				r.json()['deliveryModes'] != undefined,
			'Get shipping options has at least delivery modes ': (r) =>
				r.json()['deliveryModes'].length > 0,
		});

		const shippingMode = 'SHIPPING_STANDARD_GROUND';
		// Set shipping mode
		const setShippingOptions_response = httpPut(
			`${baseUrl}/checkout/setShippingOption?userId=${customerID}&cartId=${cartId}&deliveryModeId=${shippingMode}`,
			undefined,
			globalOptions,
			200
		);

		setShippingMethodAPITrend.add(setShippingOptions_response.timings.duration);

		check(setShippingOptions_response, {
			'Set shipping options success  ': (r) => r.status === 200,
			'Set shipping options has correct delivery mode ': (r) =>
				setShippingOptions_response.json()['deliveryMode'].code ===
				shippingMode,
		});

		const card_session_payload = JSON.stringify({
	"customer_reference": `${customerID}`,
	"account_id": "joefreshSandbox",
	"card_payment_button_text": "Review order",
	"language": "en",
	"billing_address_line1": "31-2050 Gladwin Rd",
	"billing_address_line2": "",
	"billing_address_city": "Abbotsford",
	"billing_address_postal_code": "V2S 4P8",
	"billing_address_province": "BC",
	"billing_address_country": "CA",
	"origin": "https://jf-frontshop-service-platform-sit2.loblaw.digital"
})

	const card_session = httpPost(
			`https://dev-pcexpress.api.loblaw.digital/v1/payments/tokenization/global_payments/sessions/cards`,
			card_session_payload,
			globalOptions,
			200
		);

		check(card_session, {
			'card_session API success response ': (r) => r.status === 200,
		});

		const scPayload = JSON.stringify({
	"hppResponse": {
		"HPP_FRAUDFILTER_RULE_bb11db7e-05be-4706-bd12-655d9425fccb": "UEFTUw==",
		"CVNRESULT": "TQ==",
		"PASREF": "MTY2NDQ1NjYxNjU1NzQ0NjY=",
		"VALIDATE_CARD_ONLY": "MQ==",
		"PMT_SETUP_MSG": "U3VjY2Vzc2Z1bA==",
		"SAVED_PMT_NAME": "VGVzdCBBY2NvdW50",
		"HPP_DM_RAW_RESPONSE": "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48YzpyZXBseU1lc3NhZ2UgeG1sbnM6Yz0idXJuOnNjaGVtYXMtY3liZXJzb3VyY2UtY29tOnRyYW5zYWN0aW9uLWRhdGEtMS4xMTgiPjxjOm1lcmNoYW50UmVmZXJlbmNlQ29kZT41MGMzZGQyYy02NzczLTRkOTItOTdiNC0zYTA3ZmYxZGQ3MzA8L2M6bWVyY2hhbnRSZWZlcmVuY2VDb2RlPjxjOnJlcXVlc3RJRD42NjQ0NTY2MTc1OTU2MjQ1NzA0MDA5PC9jOnJlcXVlc3RJRD48YzpkZWNpc2lvbj5BQ0NFUFQ8L2M6ZGVjaXNpb24+PGM6cmVhc29uQ29kZT4xMDA8L2M6cmVhc29uQ29kZT48YzpyZXF1ZXN0VG9rZW4+QXhpemJ3U1RhRFBoSkp5ZnRHMUpBQkVCVVJ5TVBoNTZBSTRJWk5KTXZSaXd3bHhBdUFBQTRRQXE8L2M6cmVxdWVzdFRva2VuPjxjOmFmc1JlcGx5PjxjOnJlYXNvbkNvZGU+MTAwPC9jOnJlYXNvbkNvZGU+PGM6YWZzUmVzdWx0PjQ4PC9jOmFmc1Jlc3VsdD48Yzpob3N0U2V2ZXJpdHk+MTwvYzpob3N0U2V2ZXJpdHk+PGM6Y29uc3VtZXJMb2NhbFRpbWU+NjowMzozNzwvYzpjb25zdW1lckxvY2FsVGltZT48YzphZnNGYWN0b3JDb2RlPkZeSDwvYzphZnNGYWN0b3JDb2RlPjxjOmFkZHJlc3NJbmZvQ29kZT5DT1ItQkE8L2M6YWRkcmVzc0luZm9Db2RlPjxjOmhvdGxpc3RJbmZvQ29kZT5ORUctQVNVU1BeTkVHLUJBXk5FRy1DQ15ORUctU0E8L2M6aG90bGlzdEluZm9Db2RlPjxjOmludGVybmV0SW5mb0NvZGU+TU0tSVBCQ088L2M6aW50ZXJuZXRJbmZvQ29kZT48YzpzdXNwaWNpb3VzSW5mb0NvZGU+UklTSy1UQl5VTlYtQklOPC9jOnN1c3BpY2lvdXNJbmZvQ29kZT48Yzp2ZWxvY2l0eUluZm9Db2RlPlZFTC1BRERSXlZFTC1OQU1FXlZFTEwtQ0NeVkVMVi1DQzwvYzp2ZWxvY2l0eUluZm9Db2RlPjxjOmlwQ291bnRyeT5pbjwvYzppcENvdW50cnk+PGM6aXBTdGF0ZT5kbDwvYzppcFN0YXRlPjxjOmlwQ2l0eT50dWdobGFrYWJhZCBleHRlbnNpb248L2M6aXBDaXR5PjxjOnNjb3JlTW9kZWxVc2VkPmRlZmF1bHRfY2E8L2M6c2NvcmVNb2RlbFVzZWQ+PC9jOmFmc1JlcGx5PjxjOmRlY2lzaW9uUmVwbHk+PGM6Y2FzZVByaW9yaXR5PjM8L2M6Y2FzZVByaW9yaXR5PjxjOmFjdGl2ZVByb2ZpbGVSZXBseS8+PC9jOmRlY2lzaW9uUmVwbHk+PC9jOnJlcGx5TWVzc2FnZT4=",
		"ACCOUNT": "am9lZnJlc2hTYW5kYm94",
		"AVSPOSTCODERESULT": "TQ==",
		"EXPDATE": "MTIyNQ==",
		"TIMESTAMP": "MjAyMjA5MjkxMzAyMzk=",
		"BILLING_ADDRESS_LINE_2": "",
		"AUTHCODE": "MTIzNDU=",
		"BILLING_ADDRESS_POSTAL_CODE": "VjJTIDRQOA==",
		"BILLING_ADDRESS_LINE_1": "MzEtMjA1MCBHbGFkd2luIFJk",
		"HPP_PRODUCTS_QUANTITY_1": "MQ==",
		"AVSADDRESSRESULT": "TQ==",
		"CARDNAME": "VGVzdCBBY2NvdW50",
		"HPP_BILLING_POSTALCODE": "VjJTIDRQOA==",
		"PAYER_SETUP_MSG": "U3VjY2Vzc2Z1bA==",
		"HPP_LANG": "RU4=",
		"SAVED_PMT_EXPDATE": "MTIyNQ==",
		"BATCHID": "LTE=",
		"SHA1HASH": "ODczYTE1OWEyNzllYmI5Mjc4M2I5YTU4MzFhMTUyODBiZDY4NjAwZA==",
		"HPP_CUSTOMER_FIRSTNAME": "",
		"BILLING_ADDRESS_COUNTRY": "Q0E=",
		"HPP_CUSTOMER_EMAIL": "bnVsbEBjeWJlcnNvdXJjZS5jb20=",
		"HPP_FRAUDFILTER_RULE_ab11435a-91c1-427d-92bb-45c176beb9d8": "UEFTUw==",
		"HPP_FRAUDFILTER_RULE_30aad30f-df80-45f4-b895-389e1bad4122": "UEFTUw==",
		"HPP_FRAUDFILTER_RULE_6f969529-f9e5-4fa6-952e-6dd99c759220": "UEFTUw==",
		"HPP_FRAUDFILTER_RULE_f53b310e-d027-468a-93d5-9c84d613a770": "UEFTUw==",
		"HPP_CUSTOMER_LASTNAME": "",
		"SRD": "NVNqRWJCRHNxdmlBM01sag==",
		"SAVED_PMT_REF": "OTNlODBiOTgtYWE4Yi00M2Y0LWJkZDAtNmIxZDFlNzQwOWEy",
		"HPP_FRAUDFILTER_RULE_70493710-5c24-4f1b-b766-d7f94ebd541a": "UEFTUw==",
		"BILLING_ADDRESS_STATE": "QkM=",
		"REALWALLET_CHOSEN": "MQ==",
		"HPP_FRAUDFILTER_MODE": "QUNUSVZF",
		"HPP_FRAUDFILTER_RULE_46b52e3e-9372-42da-8c2e-b9fad4486a45": "UEFTUw==",
		"MESSAGE": "WyB0ZXN0IHN5c3RlbSBdIEFVVEhPUklTRUQ=",
		"BILLING_CODE": "VjJTIDRQOHwzMS0yMDUwIEdsYWR3aW4gUmQ=",
		"HPP_PRODUCTS_TYPE_1": "ZGVmYXVsdA==",
		"pas_uuid": "YTIzNjUwNDMtZmM4NS00MjUxLWIxNzctMDEyMTU3ZTk5ZWFm",
		"HPP_PRODUCTS_UNITPRICE_1": "MA==",
		"HPP_BILLING_STREET2": "",
		"HPP_BILLING_STREET1": "MzEtMjA1MCBHbGFkd2luIFJk",
		"HPP_BILLING_CITY": "QWJib3RzZm9yZA==",
		"PMT_SETUP": "MDA=",
		"CARDDIGITS": "NDI2Mzk3eHh4eDUyNjI=",
		"BILLING_ADDRESS_CITY": "QWJib3RzZm9yZA==",
		"SAVED_PMT_TYPE": "VklTQQ==",
		"SAVED_PMT_DIGITS": "NDI2Mzk3eHh4eDUyNjI=",
		"CARD_STORAGE_ENABLE": "MQ==",
		"SAVED_PAYER_REF": "Z3Vlc3QtYWM3NzU5OTMtNWMxOC00NTRkLTljZDAtMDU4Mjc4Y2VjNDhk",
		"ORDER_ID": "NTBjM2RkMmMtNjc3My00ZDkyLTk3YjQtM2EwN2ZmMWRkNzMw",
		"BILLING_CO": "Q0E=",
		"PAYER_SETUP": "MDA=",
		"HPP_FRAUDFILTER_RULE_NAME": "QmxvY2sga25vd24gZnJhdWRzdGVyIFZhcmlhYmxlIFJlZg==",
		"CARD_PAYMENT_BUTTON": "UmV2aWV3IG9yZGVy",
		"HPP_BILLING_STATE": "QkM=",
		"HPP_FRAUDFILTER_RESULT": "UEFTUw==",
		"CARDTYPE": "VklTQQ==",
		"RESULT": "MDA=",
		"MERCHANT_ID": "bG9ibGF3c21hcmtldHBsYWNl"
	}
});

		const save_card_response = httpPost(
			`https://dev-pcexpress.api.loblaw.digital/v2/payments/tokenization/global_payments/results/cards`,
			scPayload,
			globalOptions,
			200
		);

		saveCreditCardAPITrend.add(save_card_response.timings.duration);

		check(save_card_response, {
			'Save Card API success response ': (r) => r.status === 200,
		});

		//const hpp_payload = {"hppResponse":{"CVNRESULT":"TQ==","PASREF":"MTY0NDg4ODkyNTUxNjM4ODQ=","VALIDATE_CARD_ONLY":"MQ==","PMT_SETUP_MSG":"U3VjY2Vzc2Z1bA==","SAVED_PMT_NAME":"QnJ1Y2UgV2F5bmU=","ACCOUNT":"am9lZnJlc2hTYW5kYm94Mg==","AVSPOSTCODERESULT":"TQ==","EXPDATE":"MDkyMw==","TIMESTAMP":"MjAyMjAyMTUwMTMzNTE=","BILLING_ADDRESS_LINE_2":"","AUTHCODE":"MTIzNDU=","BILLING_ADDRESS_POSTAL_CODE":"SzFZIDBYNg==","BILLING_ADDRESS_LINE_1":"MkQtMTIwIEhvbGxhbmQgQXZl","HPP_PRODUCTS_QUANTITY_1":"MQ==","AVSADDRESSRESULT":"TQ==","CARDNAME":"QnJ1Y2UgV2F5bmU=","HPP_BILLING_POSTALCODE":"SzFZIDBYNg==","HPP_LANG":"RU4=","SAVED_PMT_EXPDATE":"MDkyMw==","BATCHID":"LTE=","SHA1HASH":"NTk1OWZlNmNhMDhlMmY3MzBhYWJjMTgwNzIzMDZkYzdjOTE5MzNlYw==","HPP_CUSTOMER_FIRSTNAME":"","BILLING_ADDRESS_COUNTRY":"","HPP_CUSTOMER_EMAIL":"bnVsbEBjeWJlcnNvdXJjZS5jb20=","HPP_CUSTOMER_LASTNAME":"","SRD":"TUZHM25VcW5KWG9SVkRnVA==","SAVED_PMT_REF":"MWQzYWI5MzEtM2E5Mi00YmM3LWJjNGMtYzRjZGY1ODNmNDNh","BILLING_ADDRESS_STATE":"T04=","REALWALLET_CHOSEN":"MQ==","HPP_FRAUDFILTER_MODE":"T0ZG","MESSAGE":"WyB0ZXN0IHN5c3RlbSBdIEF1dGhvcmlzZWQ=","BILLING_CODE":"SzFZIDBYNnwyRC0xMjAgSG9sbGFuZCBBdmU=","HPP_PRODUCTS_TYPE_1":"ZGVmYXVsdA==","pas_uuid":"YzFmNTM0MWUtOTdmYS00ZDMzLThhNGQtZjAxZjQxMGJkZWFk","HPP_PRODUCTS_UNITPRICE_1":"MA==","HPP_BILLING_STREET2":"","HPP_BILLING_STREET1":"MkQtMTIwIEhvbGxhbmQgQXZl","HPP_BILLING_CITY":"T3R0YXdh","PMT_SETUP":"MDA=","CARDDIGITS":"NDExMTExeHh4eDExMTE=","BILLING_ADDRESS_CITY":"T3R0YXdh","SAVED_PMT_TYPE":"VklTQQ==","SAVED_PMT_DIGITS":"NDExMTExeHh4eDExMTE=","CARD_STORAGE_ENABLE":"MQ==","SAVED_PAYER_REF":"ZjA0OWZiZDgtZWI4MS00YWMyLWJjMjYtN2IwMzQ2Nzc2YmZj","ORDER_ID":"OTZiMDBkOTAtMmQ0NS00M2U5LThkYjktN2Q2MmE4ZGVjNThm","BILLING_CO":"","CARD_PAYMENT_BUTTON":"UmV2aWV3IG9yZGVy","HPP_BILLING_STATE":"T04=","CARDTYPE":"VklTQQ==","RESULT":"MDA=","MERCHANT_ID":"bG9ibGF3c21hcmtldHBsYWNl"}}

		// Handle Global Payment Response
		// PAYLOAD -> {"platform":"global_payments","cardType":"visa","first6":"411111","last4":"1111","cardHolderName":"Bruce Wayne","expiryMonth":"8","expiryYear":"2024","firstName":"yshfhf","lastName":"jijjs","addressLine1":"204-295 Rue De Vimy","addressLine2":"","phoneNumber":"2323678333","city":"Saint-Bruno","province":"QC","country":"CA","postalCode":"J3V 6L2","cardLength":14,"reason":"[ test system ] Authorised","resultCode":"authorized","token":"0513a37d-1ee4-48ab-a515-4f28c239955b","verificationData":{"addressLine1Check":"match","addressPostalCodeCheck":"match","cvnCheck":"match","fraudFilterResults":"not_checked"},"verificationResult":true,"saveCard":false}
		// https://jf-frontshop-service-sit.loblaw.digital/api/checkout/handleGlobalPaymentResponse?userId=3fd6e35a-11a8-414e-98b5-dca78774f81a%7Cpcidtest%40yopmail.com&cartId=651000117256715&fields=FULL
		const gp_payload = JSON.stringify({
	"platform": "global_payments",
	"cardType": "visa",
	"first6": "426397",
	"last4": "5262",
	"cardHolderName": "Test Account",
	"expiryMonth": "12",
	"expiryYear": "2025",
	"addressLine1": "31-2050 Gladwin Rd",
	"addressLine2": "",
	"phoneNumber": "",
	"city": "Abbotsford",
	"province": "BC",
	"country": "CA",
	"postalCode": "V2S 4P8",
	"cardLength": 14,
	"reason": "[ test system ] AUTHORISED",
	"resultCode": "authorized",
	"token": "c02b54fc-5e7c-4a98-8fa0-9969fd889bdc",
	"verificationData": {
		"addressLine1Check": "match",
		"addressPostalCodeCheck": "match",
		"cvnCheck": "match",
		"fraudFilterResults": "PASS"
	},
	"verificationResult": true,
	"saveCard": false
});

		const handleGlobalPayment_response = httpPost(
			`${baseUrl}/checkout/handleGlobalPaymentResponse?userId=${customerID}&cartId=${cartId}&fields=FULL`,
			gp_payload,
			globalOptions,
			200
		);

		handleGPResponseAPITrend.add(handleGlobalPayment_response.timings.duration);

		check(handleGlobalPayment_response, {
			'Handle GlobalPayment API response success  ': (r) => r.status === 200,
		});

		console.log('Guest User Id >>', guestUserId);
		console.log('Cart Id >>', cartId);
		// Place order
		// https://jf-frontshop-service-sit.loblaw.digital/api/checkout/placeGPOrder?userId=3fd6e35a-11a8-414e-98b5-dca78774f81a%7Cpcidtest%40yopmail.com&cartId=651000117256715&fields=DEFAULT
		const placeOrder_response = httpPost(
			`${baseUrl}/checkout/placeGPOrder?userId=${customerID}&cartId=${cartId}&fields=DEFAULT`,
			undefined,
			globalOptions,
			201
		);

		placeOrderAPITrend.add(placeOrder_response.timings.duration);

		console.log('placeOrder_response >>', JSON.stringify(placeOrder_response));

		check(placeOrder_response, {
			'placeOrder_response success  ': (r) => r.status === 201,
		});
	});
}

function httpGet(url, params, expectedResponseCode) {
	var res;
	for (var retries = 3; retries > 0; retries--) {
		res = http.get(url, params);
		if (res.status == expectedResponseCode) {
			return res;
		}
	}
	return res;
}

function httpPost(url, payload, params, expectedResponseCode) {
	var res;
	for (var retries = 2; retries > 0; retries--) {
		res = http.post(url, payload, params);
		if (res.status == expectedResponseCode) {
			return res;
		}
	}
	return res;
}

function httpPut(url, payload, params, expectedResponseCode) {
	var res;
	for (var retries = 2; retries > 0; retries--) {
		res = http.put(url, payload, params);
		if (res.status == expectedResponseCode) {
			return res;
		}
	}
	return res;
}

function httpDelete(url, payload, params, expectedResponseCode) {
	var res;
	for (var retries = 3; retries > 0; retries--) {
		res = http.del(url, payload, params);
		if (res.status == expectedResponseCode) {
			return res;
		}
	}
	return res;
}

export function handleSummary(data) {
	return {
		'result.html': htmlReport(data),
		stdout: textSummary(data, { indent: ' ', enableColors: true }),
	};
}
