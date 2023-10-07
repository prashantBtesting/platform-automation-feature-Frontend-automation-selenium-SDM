import { check, group, sleep, fail } from 'k6';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

import { guestUserCheckoutJourney } from './guest-user-checkout-journey.js';

export let options = {
	vus: 2,
	stages: [
		{ duration: '10m', target: 200 },
		{ duration: '120m', target: 200 },
		{ duration: '10m', target: 0 },
	],
	thresholds: {},
};

export default function () {
	guestUserCheckoutJourney();
}

export function handleSummary(data) {
	return {
		'result.html': htmlReport(data),
		stdout: textSummary(data, { indent: ' ', enableColors: true }),
	};
}
