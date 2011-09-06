package com.sethholloway;

public interface iTree<T> {

	public boolean contains(T value);

	public boolean add(T value);
	
	public boolean remove(T value);

}