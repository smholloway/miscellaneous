package com.sethholloway;

public class Utilities {
	
	private Utilities() {
		// prevent the default constructor
	}
	
	public static String removeCharacterAtIndex(String input, int index) {
		StringBuilder str = new StringBuilder();
		if (index == 0) {
			str.append(input.substring(1));
		} else if (index == input.length()) {
			str.append(input.substring(0, index));
		} else {
			str.append(input.substring(0, index));
			str.append(input.substring(index+1, input.length()));
		}
		
		return str.toString();
	}
	
	public static String numberToString(int input) {
		StringBuilder ret = new StringBuilder();
		int product   = input / 26;
		int remainder = input % 26;
		
		if (remainder == 0) {
			ret.insert(0 , (char) (26 + 64)); // Z
			product--;
		} else {
			ret.insert(0 , (char) ((remainder) + 64)); // A is 65; a is 97
		}
		
		if (product >= 1) {
			ret.insert(0 , numberToString(product));
		}
		
		return ret.toString();
	}

}
