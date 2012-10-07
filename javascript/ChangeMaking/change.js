var waysToMakeChangeHelper = function (amount, coins, accumulator) {
  if ( amount == 0 ) return [accumulator];
  if ( amount < 0 || coins.length <= 0 ) return [];
  return waysToMakeChangeHelper(amount, coins.slice(1), accumulator)
    .concat( waysToMakeChangeHelper(amount - coins[0], coins, accumulator.concat(coins[0])) );
}

var waysToMakeChange = function (amount, coins) {
  return waysToMakeChangeHelper(amount, coins, [])
}

var change = function (amount, coins) {
  if ( amount == 0 ) return 1;
  if ( amount < 0 || coins.length <= 0 ) return 0;
  return change(amount, coins.slice(1)) + change(amount - coins[0], coins);
}

var test = function () {
  // Expect 292
  console.log( change(100, [1, 5, 10, 25, 50]) === 292 ); 

  // Expect array of 292 ways to make change for a dollar with US change
  console.log( waysToMakeChange(100, [1, 5, 10, 25, 50]).length === 292 );
}

test();
