import { check, group, sleep, fail } from 'k6';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

import { browseJourney } from './browse-journey.js';
import { fullPageLoadJourneyForBrowsePages } from './full-pageload-browse-journey.js';
import { guestUserCheckoutJourney } from './guest-user-checkout-journey.js';
import { webPages } from './webPages.js';

export let options = {
	stages: [
		{ duration: '5m', target: 1000 },
		{ duration: '20m', target: 1000 },
		{ duration: '5m', target: 0 },
	],
	thresholds: {
		'http_req_duration': ['p(95)<2000'], // 99% of requests must complete below 2000ms
		'http_req_duration{status:200}': ['max>=0'],
        'http_req_duration{status:400}': ['max>=0'],
        'http_req_duration{status:500}': ['max>=0'],
        'http_req_duration{status:502}': ['max>=0'],
	},
	'summaryTrendStats': ['min', 'med', 'avg', 'p(90)', 'p(95)', 'max', 'count'],
};

export default function () {
	webPages();
	// browseJourney();
	// fullPageLoadJourneyForBrowsePages();
	// // sleep(1);
	// guestUserCheckoutJourney();
}

export function handleSummary(data) {
	return {
		'result.html': htmlReport(data),
		stdout: textSummary(data, { indent: ' ', enableColors: true }),
	};
}
