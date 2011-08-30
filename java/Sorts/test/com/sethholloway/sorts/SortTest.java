package com.sethholloway.sorts;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.sethholloway.sorts.*;

public class SortTest {
	Sort qs;
	Sort ss;
	List<Integer> sortedList;
	List<Integer> unsortedList;

	@Before
	public void setUp() throws Exception {
		qs = new Quicksort();
		ss = new SelectionSort();
		sortedList   = new ArrayList<Integer>();
		unsortedList = new ArrayList<Integer>();

		
		sortedList.add(0);
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		unsortedList.add(0);
		unsortedList.add(4);
		unsortedList.add(3);
		unsortedList.add(2);
		unsortedList.add(1);
	}
	
	@Test
	public void test_single_element_list_is_sorted() {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		assertTrue(l.equals(qs.sort(l)));
		assertTrue(l.equals(ss.sort(l)));
	}
	
	@Test
	public void test_quicksort() {
		List<Integer> afterSort = qs.sort(unsortedList);
		assertTrue(sortedList.equals(afterSort));
	}

	@Test
	public void test_selectionsort() {
		List<Integer> afterSort = ss.sort(unsortedList);
		assertTrue(sortedList.equals(afterSort));
	}
}