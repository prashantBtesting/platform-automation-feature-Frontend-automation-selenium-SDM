import { check, group, sleep, fail } from 'k6';
import { Rate } from 'k6/metrics';
import { Trend } from 'k6/metrics';
import http from 'k6/http';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

const baseUrl = 'https://jf-frontshop-service-platform-sit2.loblaw.digital/ca/api';

const baseUrlForFullPageLoad =
	'https://jf-frontshop-service-platform-sit2.loblaw.digital/ca';

//const baseUrl = 'http://local.joefresh.com:3000/ca/api';

//Transaction Metrics
const homepageFullPageLoadTrend = new Trend('GET HomePage Full Page Load ');
const categoryFullPageLoadTrend = new Trend('GET Category Full Page Load ');
const searchFullPageLoadTrend = new Trend('GET Search Full Page Load ');
const pdpFullPageLoadTrend = new Trend('GET PDP Full Page Load ');
const cartFullPageLoadTrend = new Trend('GET Cart Full Page Load ');
const categoryAPITrend = new Trend('GET /plp Category API ');
const simpleSearchAPITrend = new Trend('GET /search Simple Search API ');
const createCartAPITrend = new Trend('POST /cart/createCart Create Cart API ');
const addCartEntryAPITrend = new Trend('POST /cart/addEntry Add to Cart API ');
const pdpAPITrend = new Trend('GET /pdp PDP API ');
const productSearchAPITrend = new Trend(
	'POST /search/getSearchData Search Product API '
);

const products = JSON.parse(open('test-data/products.json'));
const categories = JSON.parse(open('test-data/categories.json'));
const searchtext = JSON.parse(open('test-data/searchtext.json'));
const articleNumbers = JSON.parse(open('test-data/productCodes.json'));

export function fullPageLoadJourneyForBrowsePages() {
	let product = products[Math.floor(Math.random() * products.length)];
	let category = categories[Math.floor(Math.random() * categories.length)];
	let text = searchtext[Math.floor(Math.random() * searchtext.length)];
	let articleNumber = articleNumbers[Math.floor(Math.random() * products.length)];

	let userId = 'anonymous';

	const globalOptions = {
		cookies: {
			Origin_Session_Cookie: 'B',
		},
		headers: {
			'Content-Type': 'application/json',
		},
	};

	group('Full Page Load for Browse Pages Journey', (data) => {
		let catg = category.id;
		let stext = text.id;
		let prod = product.id;
		let article = articleNumber.id;

		const homePage_response = httpGet(
			`${baseUrlForFullPageLoad}`,
			undefined,
			200
		);
		homepageFullPageLoadTrend.add(homePage_response.timings.duration);
		check(homePage_response, {
			'Home Page response success > ': (r) => r.status === 200,
		});

		const categoryPage_response = httpGet(
			`${baseUrlForFullPageLoad}/category-page/c/${catg}`,
			undefined,
			200
		);
		categoryFullPageLoadTrend.add(categoryPage_response.timings.duration);
		check(categoryPage_response, {
			'Category Page response success > ': (r) => r.status === 200,
		});

		const searchePage_response = httpGet(
			`${baseUrlForFullPageLoad}/search?query=${stext}`,
			undefined,
			200
		);
		searchFullPageLoadTrend.add(searchePage_response.timings.duration);
		check(searchePage_response, {
			'Search Page response success > ': (r) => r.status === 200,
		});

		const pdpPage_response = httpGet(
			`${baseUrlForFullPageLoad}/pdp-pagge/p/${prod}`,
			undefined,
			200
		);


		pdpFullPageLoadTrend.add(homePage_response.timings.duration);
		check(pdpPage_response, {
			'PDP Page response success > ': (r) => r.status === 200,
		});

		const plp_response = httpGet(
			`${baseUrl}/plp?categoryCode=${catg}`,
			undefined,
			200
		);
		categoryAPITrend.add(plp_response.timings.duration);
		check(plp_response, {
			'PLP API response success > ': (r) => r.status === 200,
		});

		const pdp_response = httpGet(`${baseUrl}/pdp/${article}`, undefined, 200);
		pdpAPITrend.add(pdp_response.timings.duration);
		check(pdp_response, {
			'PDP API response success > ': (r) => r.status === 200,
		});

		const search_product_response = httpGet(
			`${baseUrl}/search/getSearchData?productCode=${prod}`,
			undefined,
			200
		);
		productSearchAPITrend.add(search_product_response.timings.duration);
		check(search_product_response, {
			'Product Search API response success > ': (r) => r.status === 200,
		});

		const serach_response = httpGet(
			`${baseUrl}/search/getSearchData?text=${stext}`,
			undefined,
			200
		);
		simpleSearchAPITrend.add(serach_response.timings.duration);
		check(serach_response, {
			'Text Search API response success > ': (r) => r.status === 200,
		});

		const createCart_response = httpPost(
			`${baseUrl}/cart/createCart?userId=${userId}&fields=BASIC`,
			undefined,
			globalOptions,
			201
		);
		createCartAPITrend.add(createCart_response.timings.duration);
					console.log(JSON.stringify(createCart_response)),

		check(createCart_response, {
			'Create Cart API response success > ': (r) => r.status === 201
		});

		let cartId = createCart_response.json().guid;
		let payload = JSON.stringify({
			product: {
				code: product.id,
			},
			quantity: product.qty,
		});

		const addEntry_response = httpPost(
			`${baseUrl}/cart/addEntry?userId=${userId}&cartId=${cartId}&fields=BASIC`,
			payload,
			globalOptions,
			200
		);
		addCartEntryAPITrend.add(addEntry_response.timings.duration);
		check(addEntry_response, {
			'Add to Cart API response success > ': (r) => r.status === 200,
		});

		const cartPage_response = httpGet(
			`${baseUrlForFullPageLoad}/cart`,
			globalOptions,
			200
		);
		cartFullPageLoadTrend.add(cartPage_response.timings.duration);
		check(cartPage_response, {
			'Cart Page response success > ': (r) => r.status === 200,
		});
	});
}

function httpGet(url, params, expectedResponseCode) {
	var res;
	for (var retries = 1; retries > 0; retries--) {
		res = http.get(url, params);
		if (res.status == expectedResponseCode) {
			return res;
		}
	}
	return res;
}

function httpPost(url, payload, params, expectedResponseCode) {
	var res;
	for (var retries = 1; retries > 0; retries--) {
		res = http.post(url, payload, params);
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
