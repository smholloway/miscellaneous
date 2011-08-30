package com.sethholloway.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utilities {
	// prevent people from instantiating the utilities class
	private Utilities() { }
	
	public static List<Integer> init(int size, int range) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			result.add(generateRandomInt(range));
		}
		Collections.shuffle(result);
		
		return result;
	}

	
	public static List<Integer> init(int size) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			result.add(i);
		}
		Collections.shuffle(result);
		
		return result;
	}
	
	public static int generateRandomInt(int range) {
		Random generator = new Random();
		return generator.nextInt(range);
	}

}
