var ParenthesesChecker = ParenthesesChecker || {};

ParenthesesChecker.validate = function (expression) {
  var openTokens = 0,
    openToken = '(',
    closeToken = ')';
  for ( var i = 0, len = expression.length; i < len; i++ ) {
    if ( openTokens < 0 ) return false;
    if ( expression.charAt(i) === openToken ) openTokens++;
    if ( expression.charAt(i) === closeToken ) openTokens--;
  }
  return openTokens == 0;
}

ParenthesesChecker.test = function() {
  return validate('') 
    && validate('()')
    && validate('(())')
    && validate('(valid)')
    && !validate('())')
    && !validate('(()')
    && validate('var test = function() { return true }')
    && !validate('var test = function() ( { return true }')
    && validate('(function(a){return a;})(5);')
    && !validate('(function(a){return a;})(5));');
}

ParenthesesChecker.test();
