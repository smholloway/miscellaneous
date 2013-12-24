var addStringNumbers = function(input) {
  if (!input) return 0;
  var numbers = input.split(",");
  for (var i = 0, sum = 0, len = numbers.length; i < len; i++) {
    sum += parseInt(numbers[i]);
  }
  return sum;
};

var tests = function() {
  console.log( addStringNumbers() == 0 );
  console.log( addStringNumbers("") == 0 );
  console.log( addStringNumbers("1") == 1 );
  console.log( addStringNumbers("1,2") == 3 );
  console.log( addStringNumbers("1,2,3,4,5") == 15 );
};

tests();
