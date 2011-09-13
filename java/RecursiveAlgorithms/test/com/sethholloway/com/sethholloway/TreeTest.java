package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TreeTest {
	BinarySearchTree<Integer> i_bst;
	BinarySearchTree<String> s_bst;

	@Before
	public void setUp() throws Exception {
		i_bst = new BinarySearchTree<Integer>();
	}
	
	@Test
	public void test_bst_add_one_int() throws Exception {
		assertTrue(i_bst.add(0));

		assertTrue(i_bst.contains(0));
	}

	@Test
	public void test_bst_add_two_int() throws Exception {
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(1));
		
		assertTrue(i_bst.contains(0));
		assertTrue(i_bst.contains(1));
	}
	
	@Test
	public void test_bst_add_three_int() throws Exception {
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(1));
		assertTrue(i_bst.add(2));
		
		assertTrue(i_bst.contains(0));
		assertTrue(i_bst.contains(1));
		assertTrue(i_bst.contains(2));
	}
	
	@Test
	public void test_bst_add_five_int() throws Exception {
		assertTrue(i_bst.add(2));
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(1));
		assertTrue(i_bst.add(3));
		assertTrue(i_bst.add(4));
		
		assertTrue(i_bst.contains(0));
		assertTrue(i_bst.contains(1));
		assertTrue(i_bst.contains(2));
		assertTrue(i_bst.contains(3));
		assertTrue(i_bst.contains(4));
		
		i_bst.preOrder();
		i_bst.inOrder();
		i_bst.postOrder();
	}
	
	@Test
	public void test_preorder() throws Exception {
		assertTrue(i_bst.add(1));
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(2));
		
		i_bst.preOrder();
	}
	
	@Test
	public void test_inorder() throws Exception {
		assertTrue(i_bst.add(1));
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(2));
		
		i_bst.inOrder();
	}
	
	@Test
	public void test_postorder() throws Exception {
		assertTrue(i_bst.add(1));
		assertTrue(i_bst.add(0));
		assertTrue(i_bst.add(2));
		
		i_bst.postOrder();
	}

}
