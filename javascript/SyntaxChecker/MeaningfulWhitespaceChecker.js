var MeaningfulWhitespaceChecker = function () {
  // ensure the client has a new instance of MeaningfulWhitespaceChecker
  if ( !(this instanceof MeaningfulWhitespaceChecker) )
    return new MeaningfulWhitespaceChecker();
}

// naive validate implementation that counts the number open and close tokens
MeaningfulWhitespaceChecker.prototype.validate = function (expression) {
    var openTokens = 0,
      currentSpace = 0,
      lastSpace = 0,
      expectingSpace = 0,
      lines = expression.split('\n').map(function(token){ return token.replace(/\s+$/, ''); });
  for ( var i = 0, line, len = lines.length; i < len, line = lines[i]; i++ ) {
    lastSpace = currentSpace;
    currentSpace = line.split(/[^ \t\r\n]/)[0].length;
    if ( openTokens < 0 )
      return false;
    if ( lastSpace < currentSpace && expectingSpace <= 0 )
      return false;
    if ( lastSpace >= currentSpace && expectingSpace > 0 )
      return false;
      
    if ( line.substr(-1) === '{' ) {
      openTokens++;
      expectingSpace = 1;
    } else if ( line.substr(-1) === '}' ) {
      openTokens--;
      expectingSpace = -1;
    } else {
      expectingSpace = 0;
    }
  }
  return openTokens == 0;
}

// a simple test suite
MeaningfulWhitespaceChecker.prototype.test = function() {
  var jsSample1 = "\
var test = function() {\n\
  for ( var i = 0; i < 10; i++ ) {\n\
    console.log(i);\n\
  }\n\
}";
  var jsSample2 = "\
var test = function() {\n\
for ( var i = 0; i < 10; i++ ) {\n\
console.log(i);\n\
}\n\
}";
  var jsSample3 = "\
var test = function() {\n\
  for ( var i = 0; i < 10; i++ ) {\n\
    console.log(i);\n\
      }\n\
        }";
  return this.validate('') 
    && this.validate('console.log(foo);')
    && this.validate(jsSample1)
    && !this.validate(jsSample2)
    && !this.validate(jsSample3);  
}

// instantiate a few different syntax tokens
var meaningfulWhitespaceChecker = new MeaningfulWhitespaceChecker();

// ensure our tests pass for each instantiation
meaningfulWhitespaceChecker.test();