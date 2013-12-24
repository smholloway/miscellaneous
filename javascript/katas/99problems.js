/*
Adapted from Scala's 99 Problems http://aperiodic.net/phil/scala/s-99/
*/

// P01
var last = function(list) {
  return list.length > 0 ? list[list.length - 1] : list[0];
};

// P02
var penultimate = function(list) {
  return list.length > 1 ? list[list.length - 2] : list[0];
};

// P03
var nth = function(n, list) {
  return list[n];
};

// P04
var length = function(list) {
  return list.length;
};

// P05
var reverse = function(list) {
  return list.reverse();
};

// P06
var isPalindrome = function(list) {
  for (var i = 0, len = list.length; i < len; i++) {
    if (list[i] != list[len - 1 - i]) {
      return false;
    }
  }
  return true;
};

// P07
var flatten = function(list) {
  var accumulator = [];
  for (var i = 0, len = list.length; i < len; i++) {
    console.log("list = " + list + " list[" + i + "] = " + list[i] + " of type " + typeof list[i]);
    console.log("accumulator = " + accumulator);
    if (Array.isArray(list[i])) {
      accumulator = accumulator.concat( flatten(list[i]) );
    } else {
      accumulator.push( list[i] );
    }
  }
  console.log("returning = " + accumulator);
  return accumulator;
};

// P08
var compress = function(list) {
  var ret = list.slice(), i = 0, j = 1;
  while (i < ret.length) {
    j = 1;
    if ((i + j < ret.length) && ret[i] === ret[i+j]) {
      while ((i + j < ret.length) && ret[i] === ret[i+j]) { j++; }
      ret.splice(i, j-1);
    }
    i++;
  }
  return ret;
};

// P09
var pack = function(list) {
  var ret = [], sublist = [], i = 0, j = 1;
  while (i < list.length) {
    j = 1;
    if ((i + j < list.length) && list[i] === list[i+j]) {
      sublist.push(list[i]);
      while ((i + j < list.length) && list[i] === list[i+j]) {
        sublist.push(list[i]);
        j++;
      }
      ret.push(sublist);
      sublist = [];
    } else {
      ret.push(list[i]);
    }
    i = i + j;
  }
  return ret;
};

