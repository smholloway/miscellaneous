// The SICP Way
var makeChange = function(amount) {
  return makeChanges(amount, 5);
}

var makeChanges = function(amount, coins) {
  if (amount < 0 || coins <= 0) { return 0; }
  if (amount == 0) { return 1; }
  if (amount > 0) {
    return makeChanges(amount - coinValue(coins), coins) +
           makeChanges(amount, coins - 1);
  }
}

var coinValue = function(coins) {
  if (coins == 1) return 1;
  if (coins == 2) return 5;
  if (coins == 3) return 10;
  if (coins == 4) return 25;
  if (coins == 5) return 50;
}

// Alternative Style
var countChange = function(amount) {
  return countChanges(amount, [50, 25, 10, 5, 1]);
}

var countChanges = function(amount, coins) {
  if (amount < 0 || coins.length <= 0) return 0;
  if (amount == 0) return 1;
  return countChanges(amount - coins[0], coins) +
         countChanges(amount, coins.slice(1));
}

// Tests
console.log( makeChange( 1 ) == 1 );
console.log( makeChange( 5 ) == 2 );
console.log( makeChange( 10 ) == 4 );
console.log( makeChange( 11 ) == 4 );
console.log( makeChange( 25 ) == 13 );
console.log( makeChange( 100 ) == 292 );

console.log( countChange( 1 ) == 1 );
console.log( countChange( 5 ) == 2 );
console.log( countChange( 10 ) == 4 );
console.log( countChange( 11 ) == 4 );
console.log( countChange( 25 ) == 13 );
console.log( countChange( 100 ) == 292 );
