package com.sethholloway.sorts;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {

	/*
	 *	function merge_sort(m)
		    if length(m) ² 1
		        return m
		    var list left, right, result
		    var integer middle = length(m) / 2
		    for each x in m up to middle
		         add x to left
		    for each x in m after or equal middle
		         add x to right
		    left = merge_sort(left)
		    right = merge_sort(right)
		    result = merge(left, right)
		    return
	 */
	@Override
	public List<Integer> sort(List<Integer> input) {
		if (input.size() <= 1) {
			return input;
		}
		
		List<Integer> left   = new ArrayList<Integer>();
		List<Integer> right  = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		int middle = input.size() / 2;
		
		for (int i = 0; i < middle; i++) {
			left.add(input.get(i));
		}
		for (int i = middle; i < input.size(); i++) {
			right.add(input.get(i));
		}
		left   = sort(left);
		right  = sort(right);
		result = merge(left, right);
		
		return result;
	}
	
	/*
	 *	function merge(left,right)
		    var list result
		    while length(left) > 0 or length(right) > 0
		        if length(left) > 0 and length(right) > 0
		            if first(left) ² first(right)
		                append first(left) to result
		                left = rest(left)
		            else
		                append first(right) to result
		                right = rest(right)
		        else if length(left) > 0
		            append first(left) to result
		            left = rest(left)
		        else if length(right) > 0
		            append first(right) to result
		            right = rest(right)
		    end while
		    return
	 */
	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>();
		
		int l, r;
		while ( !left.isEmpty() || !right.isEmpty() ) {
			if ( left.size() > 0 && right.size() > 0 ) {
				l = left.get(0);
				r = right.get(0);
				if ( l <= r ) {
					result.add(l);
					left.remove(0);
				} else {
					result.add(r);
					right.remove(0);
				}
			} else if ( left.size() > 0 ) {
				l = left.get(0);
				result.add(l);
				left.remove(0);
			} else if ( right.size() > 0 ) {
				r = right.get(0);
				result.add(r);
				right.remove(0);
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "MergeSort [toString()=" + super.toString() + "]";
	}

}
