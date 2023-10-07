import { check, group, sleep, fail } from 'k6';
import { Rate } from 'k6/metrics';
import { Trend } from 'k6/metrics';
import http from 'k6/http';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

const baseUrl = 'https://jf-frontshop-service-platform-sit2.loblaw.digital/ca/api';

//Transaction Metrics
const categoryAPITrend = new Trend('GET /plp Category API ');
const simpleSearchAPITrend = new Trend('GET /search Simple Search API ');
const pdpAPITrend = new Trend('GET /pdp PDP API ');
const statusCodeTrend = new Trend('status code ');
const productSearchAPITrend = new Trend(
	'POST /search/getSearchData Search Product API '
);
const productRecommendationsAPITrend = new Trend(
	'POST /recommendations/getRecoProductsData  Product Recommendations API '
);

const articleNumbers = JSON.parse(open('test-data/productCodes.json'));
const products = JSON.parse(open('test-data/products.json'));
const categories = JSON.parse(open('test-data/categories.json'));
const searchtext = JSON.parse(open('test-data/searchtext.json'));
const productRecommendations = JSON.parse(
	open('test-data/product-recommendations.json')
);

export function browseJourney() {
	let product = products[Math.floor(Math.random() * products.length)];
	let category = categories[Math.floor(Math.random() * categories.length)];
	let searchTerm = searchtext[Math.floor(Math.random() * searchtext.length)];
	let productRecommendation =
		productRecommendations[
			Math.floor(Math.random() * productRecommendations.length)
		];
	let articleNumber = articleNumbers[Math.floor(Math.random() * products.length)];

	let userId = 'anonymous';

	const globalOptions = {
		cookies: {
			Origin_Session_Cookie: 'B',
		},
		headers: {
			'Content-Type': 'application/json',
			'csrf-token': 'blE3fzGiixIqThtJKodGQ5yU6pk',
		},
	};

	group('Browse journey', (data) => {
		let catg = category.id;

		const plp_response = httpGet(
			`${baseUrl}/plp?categoryCode=${catg}`,
			undefined,
			200
		);

console.log('PLP --->', plp_response.status)
		categoryAPITrend.add(plp_response.timings.duration);

		check(plp_response, {
			'PLP API response success > ': (r) => r.status === 200,
		});

		let prod = product.id;
		let article = articleNumber.id;
		const pdp_response = httpGet(`${baseUrl}/pdp/${article}`, undefined, 200);

		pdpAPITrend.add(pdp_response.timings.duration);

console.log('PDP---->', pdp_response.status)
		check(pdp_response, {
			'PDP API response success > ': (r) => r.status === 200,
		});

		const search_product_response = httpGet(
			`${baseUrl}/search/getSearchData?productCode=${prod}`,
			undefined,
			200
		);
console.log('search product--->>', search_product_response.status)

		statusCodeTrend.add(search_product_response.status);
		check(search_product_response, {
			'Product Search API response success > ': (r) => r.status === 200,
		});

		let stext = searchTerm.id;

		const serach_response = httpGet(
			`${baseUrl}/search/getSearchData?query=${stext}`,
			undefined,
			200
		);

		simpleSearchAPITrend.add(serach_response.timings.duration);
		productSearchAPITrend.add(serach_response.timings.duration);
		console.log('Search--->',JSON.stringify(serach_response.status))


		check(serach_response, {
			'Text Search API response success > ': (r) => r.status === 200,
		});

		let recommendedProducts = productRecommendation.recommended_products;

		const product_recommendations_response = httpGet(
			`${baseUrl}/recommendations/getRecoProductsData?query=${recommendedProducts}`,
			undefined,
			200
		);

console.log('Recommendation--->', product_recommendations_response.status)
		productRecommendationsAPITrend.add(
			product_recommendations_response.timings.duration
		);

		check(product_recommendations_response, {
			'Product Recommendation API response success > ': (r) => r.status === 200,
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
