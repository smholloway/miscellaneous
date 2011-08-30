package com.sethholloway;

public class LinkedList {
	private Node first;
	public int size;
	
	public LinkedList() {
		first = null;
		size  = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
		//return size == 0;
	}
	
	// insert at head
	public void insert(int value) {
		Node node = new Node(value);
		node.next = first;
		first = node;
		size++;
	}
	
	// delete the first node
	public Node delete() {
		Node temp = first;
		first = first.next;
		size--;
		return temp;
	}
	
	public void recursiveReverse() {
		first = reverse(first, null);
	}
	
	public Node reverse(Node i, Node prev) {
		Node temp = i.next;
		i.next = prev;
		if (temp == null) {
			return i;
		} else {
			return reverse(temp, i);
		}
	}
	
	// reverse LinkedList in place
	public void reverse() {
		if (this.size <= 1) {
			return;
		}
		
		Node i    = first;
		Node prev = null;
		Node next = i.next;
		
		while (next != null) {
			i.next = prev;
			prev   = i;
			i      = next;
			next   = next.next;
		}
		
		i.next = prev;
		first = i;
	}
	
	// generic to string method
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		Node i = first;
		while (i != null) {
			ret.append(i.getValue());
			i = i.next;
			if (i != null) {
				ret.append(", ");
			}
		}
		return ret.toString();
	}

}
