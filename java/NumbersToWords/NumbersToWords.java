/**
 * ASM Coding project
 * Transform an input number to it's output words
 * Ex: 1 -> one. 19 -> nineteen
 *
 * Time taken:
 *  Set up class and verified compilation: 5 minutes
 *  Set up dummy methods: 1 minute
 * @author <a href="mailto:smholloway@gmail.com">Seth Holloway</a>
 */
public class NumbersToWords {

    public static void main(String[] args) {
        System.out.println(NumberToWord(1));
        System.out.println(NumberToWord(11));
    }

    public static String NumberToWord(Integer inputNumber) {
      System.out.println(inputNumber);
      String ret = new String();
      if (inputNumber == 0) ret = "zero";
      if (inputNumber == 1) ret = "one";
      if (inputNumber == 2) ret = "two";
      if (inputNumber == 3) ret = "three";
      if (inputNumber == 4) ret = "four";
      if (inputNumber == 5) ret = "five";
      if (inputNumber == 6) ret = "six";
      if (inputNumber == 7) ret = "seven";
      if (inputNumber == 8) ret = "eight";
      if (inputNumber == 9) ret = "nine";
      if (inputNumber == 10) ret = "ten";
      if (inputNumber == 11) ret = "eleven";
      if (inputNumber == 12) ret = "twelve";
      if (inputNumber == 13) ret = "thirteen";
      if (inputNumber == 14) ret = "fourteen";
      if (inputNumber == 15) ret = "fifteen";
      if (inputNumber == 16) ret = "sixteen";
      if (inputNumber == 17) ret = "seventeen";
      if (inputNumber == 18) ret = "eighteen";
      if (inputNumber == 19) ret = "nineteen";
      return ret;
    }

    public static String NumberToWord(String inputNumber) {
      System.out.println(inputNumber);
      String ret = new String();
      if (inputNumber == "0") ret = "zero";
      if (inputNumber == "1") ret = "one";
      if (inputNumber == "2") ret = "two";
      if (inputNumber == "3") ret = "three";
      if (inputNumber == "4") ret = "four";
      if (inputNumber == "5") ret = "five";
      if (inputNumber == "6") ret = "six";
      if (inputNumber == "7") ret = "seven";
      if (inputNumber == "8") ret = "eight";
      if (inputNumber == "9") ret = "nine";
      if (inputNumber == "10") ret = "ten";
      if (inputNumber == "11") ret = "eleven";
      if (inputNumber == "12") ret = "twelve";
      if (inputNumber == "13") ret = "thirteen";
      if (inputNumber == "14") ret = "fourteen";
      if (inputNumber == "15") ret = "fifteen";
      if (inputNumber == "16") ret = "sixteen";
      if (inputNumber == "17") ret = "seventeen";
      if (inputNumber == "18") ret = "eighteen";
      if (inputNumber == "19") ret = "nineteen";
      return ret;
    }
}
