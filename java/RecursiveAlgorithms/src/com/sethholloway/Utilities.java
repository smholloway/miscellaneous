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

}
