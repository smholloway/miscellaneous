package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TreeTest {
	BinarySearchTree bst;

	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree();
	}
	
	@Test
	public void test_bst_add_one() throws Exception {
		assertTrue(bst.add(0));

		assertTrue(bst.contains(0));
		
	}

	@Test
	public void test_bst_add_two() throws Exception {
		assertTrue(bst.add(0));
		assertTrue(bst.add(1));
		
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
	}

}
