var a2r = function(input) {
  if (input == 1) return 'I';
  if (input > 1 && input < 4) return a2r(1) + a2r(input-1);
  if (input == 4) return 'IV';
  if (input == 5) return 'V';
  if (input > 5 && input < 9) return a2r(5) + a2r(input-5);
  if (input == 9) return 'IX';
  if (input == 10) return 'X';
  if (input > 10) return a2r(10) + a2r(input-10);
};

var tests = function() {
  console.log( a2r(1) == 'I' );
  console.log( a2r(2) == 'II' );
  console.log( a2r(3) == 'III' );
  console.log( a2r(4) == 'IV' );
  console.log( a2r(5) == 'V' );
  console.log( a2r(6) == 'VI' );
  console.log( a2r(9) == 'IX' );
  console.log( a2r(10) == 'X' );
  console.log( a2r(15) == 'XV' );
  console.log( a2r(19) == 'XIX' );
  console.log( a2r(26) == 'XXVI' );
  console.log( a2r(30) == 'XXX' );
};

tests();

