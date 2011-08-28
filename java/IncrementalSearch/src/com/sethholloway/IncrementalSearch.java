package com.sethholloway;

import java.util.Set;

public interface IncrementalSearch {

	public abstract void addWord(String word);

	public abstract void addWords(Iterable<String> words);

	public abstract Set<String> search(String input);

}