var keys = [],
	last, 
	current, 
	difference, 
	sum = 0, 
	firstReading = true;

var updateUI = function() {
	var average = 0,
		standardDeviation = 0,
		lastTimeBetweenKeys = 0;

	if (keys.length) {
		average = sum/keys.length || 0,
		standardDeviation = Math.sqrt(keys.map(function(x) {return Math.pow(average-x, 2)	}).reduce(function(x, y) {return x + y}) / keys.length) || 0,
		lastTimeBetweenKeys = keys[keys.length-1] || 0;
	}

	document.getElementById("timingAverage").innerHTML = average;
	document.getElementById("timingStandardDeviation").innerHTML = standardDeviation;
	document.getElementById("timingLast").innerHTML = lastTimeBetweenKeys;
}

var resetTiming = function() {
	keys = [];
	last = undefined;
	current = undefined;
	difference = 0;
	sum = 0;
	firstReading = true;

	updateUI();
}

window.onkeypress = keypressHandler;

function keypressHandler() {
	last = current || Date.now();
	current = Date.now();
	if (firstReading) {
		firstReading = false;
		return;
	}
	difference = current - last;
	sum += difference;
	keys.push(difference);
	updateUI();
}