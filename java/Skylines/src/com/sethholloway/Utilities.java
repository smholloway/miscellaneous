package com.sethholloway;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utilities {
	// prevent people from instantiating the class
	private Utilities() { }
	
	/*
	 * utility method to remove duplicates from an array list
	 */
	public static List<?> removeDuplicateWithOrder(List<?> list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Object e : list) {
			if (set.add(e)) {
				newList.add(e);
			}
		}
		return newList;
	}

}
