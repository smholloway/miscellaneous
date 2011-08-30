package com.sethholloway;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testRemoveDuplicateWithOrder() {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> noDuplicatesManual = new ArrayList<Integer>();
		list.add(0);
		list.add(0);  noDuplicatesManual.add(0);
		list.add(1);  noDuplicatesManual.add(1);
		list.add(2);  noDuplicatesManual.add(2);
		List<Integer> noDuplicates = (List<Integer>)Utilities.removeDuplicateWithOrder(list);
		assertEquals("Duplicates", noDuplicatesManual, noDuplicates);
	}

}
