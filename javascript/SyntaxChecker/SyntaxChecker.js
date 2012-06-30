var SyntaxChecker = function (openToken, closeToken) {
  // ensure the client has a new instance of SyntaxChecker
  if ( !(this instanceof arguments.callee) ) 
    return new SyntaxChecker(openToken, closeToken); 

  // if no tokens were given, default to parentheses
  this.openToken = openToken || '(';
  this.closeToken = closeToken || ')';

  // naive validate implementation that counts the number open and close tokens
  this.validate = function (expression) {
    var openTokens = 0;
    for ( var i = 0, len = expression.length; i < len; i++ ) {
      if ( openTokens < 0 )
        return false;
      if ( expression.charAt(i) === openToken ) {
        openTokens++;
      } else if ( expression.charAt(i) === closeToken ) {
        openTokens--;
      }
    }
    return openTokens == 0;
  }

  // a simple test suite
  this.test = function() {
    return validate('') 
      && validate('true')
      && validate(openToken + closeToken)
      && !validate(closeToken + openToken)
      && validate(openToken + closeToken + openToken + closeToken)
      && !validate(closeToken + openToken + closeToken)
      && !validate(openToken + openToken + closeToken)
      && validate(openToken + 'valid' + closeToken)
      && !validate(openToken + 'invalid')
      && !validate('invalid' + closeToken)
      && validate('var test = function() { return true }')
      && validate('(function(a){return a;})(5);')
      && validate('(function(a){return [a, a];})(5);');
      /*
      && !validate('var test = function() ( { return true }')
      && !validate('(function(a){return a;})(5));')
      && !validate('(function(a){return [[a, a];})(5);')
      && !validate('(function(a){return [a, a]];})(5);');
      */
  }
}

var CurlyBraceChecker = CurlyBraceChecker || new SyntaxChecker('{', '}'),
  SquareBraceChecker = SquareBraceChecker || new SyntaxChecker('[', ']'),
  ParenthesesChecker = ParenthesesChecker || new SyntaxChecker('(', ')');

CurlyBraceChecker.test();
SquareBraceChecker.test();
ParenthesesChecker.test();
