/*
* Conway's Game of Life
* Your task is to write a program to calculate the next
* generation of Conway's game of life, given any starting
* position. You start with a two dimensional grid of cells, 
* where each cell is either alive or dead. The grid is finite, 
* and no life can exist off the edges. When calculating the 
* next generation of the grid, follow these four rules:
*
* 1. Any live cell with fewer than two live neighbours dies, 
*    as if caused by underpopulation.
* 2. Any live cell with more than three live neighbours dies, 
*    as if by overcrowding.
* 3. Any live cell with two or three live neighbours lives 
*    on to the next generation.
* 4. Any dead cell with exactly three live neighbours becomes 
*    a live cell.
*
* Examples: * indicates live cell, . indicates dead cell
*
*     Example input: (4 x 8 grid)
*     4 8
*     ........
*     ....*...
*     ...**...
*     ........
* 
*     Example output:
*     4 8
*     ........
*     ...**...
*     ...**...
*     ........
*/
var gameOfLife = function(input) {
  var output = input;
  for (var r = 0; r < input.length; r++) {
    for (var c = 0; c < input[r].length; c++) {
      var neighborsAlive = liveNeighbors(r, c, input);
      if (isAlive(r, c, input)) { // live cell
        if (neighborsAlive < 2 || neighborsAlive > 3) {
          output = setCharInArrayOfStrings(output, r, c, ".");
        }
      } else { // dead cell
        if (neighborsAlive == 3) {
          output = setCharInArrayOfStrings(output, r, c, "*");
        }
      }
    }
  }
  return output;
};

var liveNeighbors = function(r, c, input) {
  return isAlive(r - 1, c - 1, input) +
         isAlive(r - 1, c,     input) +
         isAlive(r - 1, c + 1, input) +
         isAlive(r, c - 1,     input) +
         isAlive(r, c + 1,     input) +
         isAlive(r + 1, c - 1, input) +
         isAlive(r + 1, c,     input) +
         isAlive(r + 1, c + 1, input);
};

var isAlive = function(r, c, input) {
  if (r < 0 || c < 0) return 0;
  if (r >= input.length || c >= input[0].length) return 0;
  if (input[r][c] == ".") return 0;
  if (input[r][c] == "*") return 1;
};

// =====================================================
// Tests
// =====================================================
var tests = function() {
  var gameStateStart = ["........",
                        "....*...",
                        "...**...",
                        "........"];
  var gameStateEnd   = ["........",
                        "...**...",
                        "...**...",
                        "........"];
  console.log( arraysEqual(gameOfLife(gameStateStart), gameStateEnd) );
};

tests();

// =====================================================
// Helper functions to get around JavaScript's funkytown
// =====================================================
var arraysEqual = function(a, b) {
  if (a === b) return true;
  if (a == null || b == null) return false;
  if (a.length != b.length) return false;

  for (var i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) return false;
  }
  return true;
};

function setCharInArrayOfStrings(input, r, c, replaceWith) {
  if (r >= input.length) return;
  if (c >= input[0].length) return;
  var line = input[r];
  input[r] = line.substr(0, c) + replaceWith + line.substr(c + 1);
  return input;
}
