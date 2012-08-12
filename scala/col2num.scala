/** Column to number kata
  * Convert an input String representing a spreadsheet column to the column number
  * Examples:
  *   col2num("a") -> 1
  *   col2num("z") -> 26
  *   col2num("aa") -> 27
  *   col2num("aaa") -> 703
  */
def col2num(str: String): Int = {
  var num = 0
  var index = 0
  str.toUpperCase.reverse.foreach { c =>
    num = num + ((c - 'A' + 1) * scala.math.pow(26, index).toInt)
    index += 1
  }
  num
}
