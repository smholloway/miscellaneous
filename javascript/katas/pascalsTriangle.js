/*
* Pascal's Triangle http://en.wikipedia.org/wiki/Pascal's_triangle
* 1                   0,0 = 1
* 1 1                 1,0 = 1 | 1,1 = 1
* 1 2 1               2,0 = 1 | 2,1 = 2 | 2,2 = 1
* 1 3 3 1             3,0 = 1 | 3,1 = 3 | 3,2 = 3 | 3,3 = 1 |
* 1 4 6 4 1           4,0 = 1 | 4,1 = 4 | 4,2 = 6 | 4,3 = 4 | 4,4 = 1 |
* 1 5 A A 5 1         5,0 = 1 | 5,1 = 5 | 5,2 = A | 5,3 = A | 5,4 = 5 | 5,5 = 1 |
*/
var pascalsTriangle = function(r, c) {
  if (typeof r === "undefined" || typeof c === "undefined" || r < 0 || c < 0 || r < c) return 0
  if (r == c || c == 0) return 1;
  return pascalsTriangle(r - 1, c) + pascalsTriangle(r - 1, c - 1);
};

var tests = function() {
  // error checking
  console.log( pascalsTriangle(-1, -1) == 0 );
  console.log( pascalsTriangle(0, 1) == 0 );
  // standard pascals triangle
  console.log( pascalsTriangle(0, 0) == 1 );
  console.log( pascalsTriangle(1, 1) == 1 );
  console.log( pascalsTriangle(2, 1) == 2 );
  console.log( pascalsTriangle(4, 2) == 6 );
};

tests();
