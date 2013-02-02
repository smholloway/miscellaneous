// Add all the natural numbers below one thousand that are multiples of 3 or 5.

// Create a list of numbers from 1 to 1000
var i = 0, x = [];
while (++i < 1000) x.push(i);

// Create a list of multiples of 3 and 5 then sum the list
x.filter(function(i) {
  return (i % 3 == 0 || i % 5 == 0);
}).reduce(function(a,b) {
  return a + b;
});
// 233168
