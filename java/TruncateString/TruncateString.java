public class TruncateString {

	public static void main( String[] args ) {
		String oneHundredString 
			= "0123456789"  //10
			+ "0123456789"  //20
			+ "0123456789"  //30
			+ "0123456789"  //40
			+ "0123456789"  //50
			+ "0123456789"  //60
			+ "0123456789"  //70
			+ "0123456789"  //80
			+ "0123456789"  //90
			+ "0123456789"; //100
		String underOneHundredString 
			= "0123456789"  //10
			+ "0123456789"  //20
			+ "0123456789"  //30
			+ "0123456789"  //40
			+ "0123456789"  //50
			+ "0123456789"  //60
			+ "0123456789"  //70
			+ "0123456789"  //80
			+ "0123456789"; //90
		String overOneHundredString 
			= "0123456789"  //10
			+ "0123456789"  //20
			+ "0123456789"  //30
			+ "0123456789"  //40
			+ "0123456789"  //50
			+ "0123456789"  //60
			+ "0123456789"  //70
			+ "0123456789"  //80
			+ "0123456789"  //90
			+ "0123456789"  //100
			+ "0123456789"; //110
		String spaceInString 
			= "012345678 "  //10
			+ "01234567 9"  //20
			+ "0123456 89"  //30
			+ "012345 789"  //40
			+ "01234 6789"  //50
			+ "0123 56789"  //60
			+ "012 456789"  //70
			+ "01 3456789"  //80
			+ "0 23456789"  //90
			+ " 123456789"; //100
		int len = 100;

		System.out.println( truncateString(underOneHundredString, len) );
		System.out.println( truncateString(overOneHundredString, len) );
		System.out.println( truncateString(spaceInString, len) );
		System.out.println( truncateString(oneHundredString, len) );
	}

	/*
	 * truncate the input string to input length without breaking a word
	 * there are four options: 
	 * (1) over 100 characters without a space  -> truncate at space
	 * (2) over 100 characters with a space     -> no truncation possible
	 * (3) under 100 characters without a space -> return full string
	 * (4) under 100 characters with a space    -> return full string
	 */
	public static String truncateString( String input, int len ) {
		int spaceAt = 0;
		if ( input.length() <= len ) {
			return input;
		} else {
			spaceAt = input.lastIndexOf( " ", len+1 );
			if ( spaceAt > 0 ) {
				return input.substring( 0, spaceAt );
			} else {
				return "";
			}
		}
	}
}
