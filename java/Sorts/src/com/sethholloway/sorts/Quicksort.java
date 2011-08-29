package com.sethholloway.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quicksort implements Sort {
	
	public List<Integer> sort(List<Integer> input) {
		if (input.size() <= 1) {
			return input;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> left   = new ArrayList<Integer>();
		List<Integer> right  = new ArrayList<Integer>();
		
		Integer pivot        = input.get(input.size()/2);
		input.remove(pivot);

		for (int i : input) {
			if (i < pivot) {
				left.add(i);
			} else {
				right.add(i);
			}
		}
		
		left  = sort(left);
		right = sort(right);
		
		if (!left.isEmpty()) {
			result.addAll(sort(left));
		}
		result.add(pivot);
		if (!right.isEmpty()) {
			result.addAll(right);
		}
		return result;
	}
}
