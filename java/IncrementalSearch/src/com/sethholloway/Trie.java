package com.sethholloway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Trie implements IncrementalSearch {
	private Map<String, Set<String>> searchMap;
	
	public Trie() {
		searchMap = new HashMap<String, Set<String>>();
	}
	
	public Trie(List<String> words) {
		searchMap = new HashMap<String, Set<String>>();
		for (String word : words) {
			addWord(word);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sethholloway.IncrementalSearch#addWord(java.lang.String)
	 */
	@Override
	public void addWord(String word) {
		for (int i = 1; i < word.length(); i++) {
			String key = word.substring(0, i).toLowerCase();
			Set<String> value;
			if (searchMap.containsKey(key)) {
				value = searchMap.get(key);
			} else {
				value = new TreeSet<String>();
			}
			value.add(word);
			searchMap.put(key, value);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sethholloway.IncrementalSearch#addWords(java.util.Iterable)
	 */
	@Override
	public void addWords(Iterable<String> words) {
		for (String s : words) {
			addWord(s);
		}	
	}
	
	/* (non-Javadoc)
	 * @see com.sethholloway.IncrementalSearch#search(java.lang.String)
	 */
	@Override
	public Set<String> search(String input) {
		return searchMap.get(input);
	}
}
