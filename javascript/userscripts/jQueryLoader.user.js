// This script lets you like xvideos
//
// ==UserScript==
// @name          jQueryLoader
// @namespace     jQueryLoader
// @description   Load jQuery into any page for use with inspector
// @include       http://*
// @include       file:///*
// @version				1
// @require 			http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js
// ==/UserScript==

try{
	// a function that loads jQuery and calls a callback function when jQuery has finished loading
	function addJQuery(callback) {
		var script = document.createElement("script");
		script.setAttribute("src", "http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js");
		script.addEventListener('load', function() {
			var script = document.createElement("script");
			script.textContent = "(" + callback.toString() + ")();";
			document.body.appendChild(script);
		}, false);
		document.body.appendChild(script);
	}

	// load jQuery and execute the main function
	addJQuery(main);

	// the guts of this userscript
	function main() {
		alert('Loaded jQuery');
	}
} catch(e) {
	alert("jQueryLoader encountered an error: " + e);
}
