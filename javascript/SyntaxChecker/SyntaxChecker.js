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
      if ( expression.charAt(i) === this.openToken ) {
        openTokens++;
      } else if ( expression.charAt(i) === this.closeToken ) {
        openTokens--;
      }
    }
    return openTokens == 0;
  }

  // a simple test suite
  this.test = function() {
    return this.validate('') 
      && this.validate('true')
      && this.validate(openToken + this.closeToken)
      && !this.validate(closeToken + this.openToken)
      && this.validate(openToken + this.closeToken + this.openToken + this.closeToken)
      && !this.validate(closeToken + this.openToken + this.closeToken)
      && !this.validate(openToken + this.openToken + this.closeToken)
      && this.validate(openToken + 'valid' + this.closeToken)
      && !this.validate(openToken + 'invalid')
      && !this.validate('invalid' + this.closeToken)
      && this.validate('var test = function() { return true }')
      && this.validate('(function(a){return a;})(5);')
      && this.validate('(function(a){return [a, a];})(5);');
  }
}

// instantiate a few different syntax tokens
var CurlyBraceChecker = CurlyBraceChecker || new SyntaxChecker('{', '}'),
  SquareBraceChecker = SquareBraceChecker || new SyntaxChecker('[', ']'),
  ParenthesesChecker = ParenthesesChecker || new SyntaxChecker('(', ')');

// ensure our tests pass for each instantiation
CurlyBraceChecker.test();
SquareBraceChecker.test();
ParenthesesChecker.test();
