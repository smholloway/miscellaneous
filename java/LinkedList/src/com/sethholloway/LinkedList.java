package com.sethholloway;

public class LinkedList {
	private Node head;
	public int size;
	
	public LinkedList() {
		head = null;
		size  = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
		//return size == 0;
	}
	
	// insert at head
	public void insert(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
		size++;
	}
	
	public void insertAt(int value, int position) {
		if (position > size) {
			return;
		}
		
		// head insertion is a special case
		if (position == 0) {
			insert(value);
			return;
		}
		
		Node node    = new Node(value);
		Node current = head;
		int index    = 0;
		while (index < position && current != null) {
			current = current.next;
			
			index++;
		}
		
		size++;
	}
	
	public void swapNode(int position1, int position2) {
		if (position1 > size || position2 > size) {
			return;
		}
		if (position1 == position2) {
			return;
		}
		
		int index    = 0;
		Node current = head;
		Node position1Previous = null, position1Node = null, position1Next = null;
		Node position2Previous = null, position2Node = null, position2Next = null;
		while (current != null) {
			if ( (position1 - index) == 1 ) {
				position1Previous = current;
			} else if ( index == position1 ) {
				position1Next = current.next;
				position1Node = current;
			}
			
			if ( (position2 - index) == 1 ) {
				position2Previous = current;
			} else if ( index == position2 ) {
				position2Next = current.next;
				position2Node = current;
			}
				
			index++;
			current = current.next;
		}
		
		Node temp              = position1Node;
		position1Node          = position2Node;
		position2Node          = temp;
		position1Node.next     = position2Next; 
		position2Node.next     = position1Next; 
		position1Previous.next = position2Node;
		position2Previous.next = position1Node;	
	}
	
	public void swap(int position1, int position2) {
		if (position1 > size || position2 > size) {
			return;
		}
		if (position1 == position2) {
			return;
		}
		
		int index    = 0;
		Node current = head;
		Node position1Node = null, position2Node = null;
		while (current != null) {
			if ( index == position1 ) {
				position1Node = current;
			}
			
			if ( index == position2 ) {
				position2Node = current;
			}
				
			index++;
			current = current.next;
		}
		
		int temp = position1Node.getValue();
		position1Node.setValue(position2Node.getValue());
		position2Node.setValue(temp);
	}
	
	// delete the first node
	public Node delete() {
		Node temp = head;
		head = head.next;
		size--;
		return temp;
	}
	
	public void reverseKata() {
		if (this.size <= 1) {
			return;
		}
		
		Node prev    = null;
		Node current = head;
		Node next    = head.next;
		
		while ( next != null ) {
			current.next = prev;
			prev         = current;
			current      = next;
			next         = next.next;
		}
		
		current.next = prev;
		head = current;
	}
	
	public void recursiveReverse() {
		head = reverse(head, null);
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
		
		Node i    = head;
		Node prev = null;
		Node next = i.next;
		
		while (next != null) {
			i.next = prev;
			prev   = i;
			i      = next;
			next   = next.next;
		}
		
		i.next = prev;
		head = i;
	}
	
	// generic to string method
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		Node i = head;
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
