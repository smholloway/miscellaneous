package com.sethholloway;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class TrieTest {
	private IncrementalSearch trie;
	
	@Before 
	public void setUp() throws Exception {
		trie = new Trie();
		List<String> words = initializeWords();
		trie.addWords(words);
	}
	
	private List<String> initializeWords() {
		List<String> words = new ArrayList<String>();
		// a few cities
		words.add("Austin, TX");
		words.add("Amherst, CN");
		words.add("Akron, OH");
		words.add("Armonk, NY");
		words.add("Amarillo, TX");
		words.add("Anapolis, MY");
		words.add("Anaheim, CA");
		words.add("Albequerque, NM");
		words.add("Boston, MA");
		words.add("Belhaven, CN");
		// a few states
		words.add("California");
		words.add("Connecticutt");
		words.add("Massachusetts");
		words.add("Maryland");
		words.add("New Mexico");
		words.add("New York");
		words.add("Ohio");
		words.add("Texas");
		
		return words;
	}
	
	@Test
	public void test_search_takes_under_a_second() throws Exception {
		final long endTime, startTime = System.nanoTime();
		Iterable<String> values = null;
		try {
		 values = trie.search("au");
		} finally {
		  endTime = System.nanoTime();
		}
		
		//here we could print the values if needed...
		
		final long duration = endTime - startTime;
		System.out.println("Method took " + duration + " nanoseconds " +
				"(" + duration/1000L + " microseconds or " + 
				duration/1000000L + " milliseconds" + ")");
		
		assertTrue(duration/1000L < 1000);
	}
	
	@Test
	public void test_trie_with_a() throws Exception {
		//test with an a here
		Set<String> values = trie.search("a");
		
		//words that should be seen
		Collection<String> shouldContainWords = new ArrayList<String>();
		shouldContainWords.add("Austin, TX");
		shouldContainWords.add("Amherst, CN");
		shouldContainWords.add("Akron, OH");
		shouldContainWords.add("Armonk, NY");
		shouldContainWords.add("Amarillo, TX");
		shouldContainWords.add("Anapolis, MY");
		shouldContainWords.add("Anaheim, CA");
		shouldContainWords.add("Albequerque, NM");
		
		assertTrue(values.containsAll(shouldContainWords));
	}
}
