package com.sethholloway.sorts;

import java.util.List;

public class SelectionSort {
	
	public List<Integer> sort(List<Integer> input) {
		List<Integer> result = input;

		int i, j, temp;
		for (i = 0; i < result.size(); i++) {
			for (j = i; j < result.size(); j++) {
				if (result.get(i) > result.get(j)) {
					//Collections.swap(result, i, j);
					//if we're going to use collections, we may as well use their sort!
					//let's do the swap on our own
					temp = result.get(i);
					result.set(i, result.get(j));
					result.set(j, temp);					
				}
			}
		}
		
		return result;
	}
}
