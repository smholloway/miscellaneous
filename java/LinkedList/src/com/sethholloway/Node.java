package com.sethholloway;

public class Node {
	private int value;
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node next;
	
	public Node(int input) {
		value = input;
	}
	
	@Override
	public String toString() {
		return "(" + value + ")";
	}
}
