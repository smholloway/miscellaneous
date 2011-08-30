package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sethholloway.LinkedList;
import com.sethholloway.Node;


public class TestLinkedList {
	LinkedList ll;
	
	@Before
	public void setUp() throws Exception {	
		ll = new LinkedList();
	}
	
	@Test
	public void test_new_list_is_empty() {
		assertTrue(ll.isEmpty());
	}
	
	@Test
	public void test_insert() {
		ll.insert(1);
		assertEquals(1, ll.size);
		ll.insert(2);
		assertEquals(2, ll.size);
	}
	
	@Test
	public void test_delete() {
		ll.insert(1);
		assertEquals(1, ll.size);
		Node dn = ll.delete();
		assertEquals(1, dn.getValue());
		assertTrue(ll.isEmpty());
	}
	
	@Test
	public void test_reverse_one_element_is_element() {
		LinkedList nl = new LinkedList();
		ll.insert(1);
		nl.insert(1);
		ll.reverse();
		assertEquals(nl.toString(), ll.toString());
	}
	
	@Test
	public void test_reverse_two_elements() {
		LinkedList nl = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		nl.insert(2);
		nl.insert(1);
		ll.reverse();
		assertEquals(nl.toString(), ll.toString());
	}
	
	@Test
	public void test_reverse_more_elements() {
		LinkedList nl = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.reverse();
		
		nl.insert(4);
		nl.insert(3);
		nl.insert(2);
		nl.insert(1);

		assertEquals(nl.toString(), ll.toString());
	}
	
	@Test
	public void test_recursive_reverse_more_elements() {
		LinkedList nl = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.recursiveReverse();
		
		nl.insert(4);
		nl.insert(3);
		nl.insert(2);
		nl.insert(1);

		assertEquals(nl.toString(), ll.toString());
	}

}
