import { check, group, sleep, fail } from 'k6';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

import { browseJourney } from './browse-journey.js';
import { fullPageLoadJourneyForBrowsePages } from './full-pageload-browse-journey.js';

export let options = {
	vus: 2,
	stages: [
		{ duration: '10s', target: 2 },
		// { duration: '20m', target: 400 },
		// { duration: '10m', target: 0 },
	],
	thresholds: {
		http_req_duration: ['p(95)<2000'], // 99% of requests must complete below 2000ms
	},
};

export default function () {
	fullPageLoadJourneyForBrowsePages();
	browseJourney();
	sleep(1);
}

export function handleSummary(data) {
	return {
		'result.html': htmlReport(data),
		stdout: textSummary(data, { indent: ' ', enableColors: true }),
	};
}
