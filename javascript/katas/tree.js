/*
 * @author Seth Holloway
 * side-effect free tree traversals that return an ordered array
 */

var inOrderTraversal = function (tree) {
  if ( tree === null || typeof(tree) === 'undefined') {
    return [];
  }
  return inOrderTraversal(tree.left).concat(tree.value).concat( inOrderTraversal(tree.right) );
}

var preOrderTraversal = function (tree) {
  if ( tree === null || typeof(tree) === 'undefined') {
    return [];
  }
  return [tree.value].concat( preOrderTraversal(tree.left).concat(preOrderTraversal(tree.right)) );
}

var postOrderTraversal = function (tree) {
  if ( tree === null || typeof(tree) === 'undefined') {
    return [];
  }
  return postOrderTraversal(tree.left).concat( postOrderTraversal(tree.right)).concat(tree.value );
}


var simpleTree = {
	value: 0, 
  left: {
		value: 1, 
    left: null,
    right: { value: 2, left: null, right: null }
  },
  right: { value: 3, left: null, right: null }
}

// http://en.wikipedia.org/wiki/Tree_traversal#Example
var complexTree = {
	value: 'F', 
  left: {
		value: 'B', 
    left: { value: 'A', left: null, right: null },
    right: {
			value: 'D', 
			left: { value: 'C', left: null, right: null }, 
			right: { value: 'E', left: null, right: null }
		}
  },
  right: {
		value: 'G',
		left: null,
		right: {
			value: 'I',
			left: { value: 'H', right: null, left: null },
			right: null 
		}
	}
}


var inOrder = inOrderTraversal( complexTree );
var preOrder = preOrderTraversal( complexTree );
var postOrder = postOrderTraversal( complexTree );
console.log( 'In-order traversal: ' + inOrder );
console.log( 'Pre-order traversal: ' + preOrder );
console.log( 'Post-order traversal: ' + postOrder );
