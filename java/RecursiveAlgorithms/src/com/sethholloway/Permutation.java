package com.sethholloway;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	private List<String> permutations;
	
	public Permutation() {
		permutations = new ArrayList<String>();
	}
	
	public Permutation(String input) {
		permutations = new ArrayList<String>();
		permute(input);
	}
	
	public List<String> getPermutations() {
		return permutations;
	}
	
	private boolean addPermutation(String permutation) {
		return permutations.add(permutation);
	}
	
	/*
	 * @args input - the string to permute
	 */
	public void permute(String input) {
		permute(input, "");
	}
	
	/*
	 * @args input  - a string to permute 
	 * @args output - the permutation
	 * Recursive method to create all permutations of the original input string
	 * We have a new permutation whenever the input string is empty (the output
	 *   string will be the length of the original string)
	 */
	private void permute(String input, String output) {
		if (input.length() <= 0 && !output.isEmpty()) {
			addPermutation(output);
		} else { // we do not have a full-length permutation yet
			char charAt;
			for (int i = 0; i < input.length(); i++) {
				charAt = input.charAt(i);
				permute(Utilities.removeCharacterAtIndex(input, i), output+charAt);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation();
		p.permute("1234");
		System.out.println(p.permutations.toString());
	}
}
