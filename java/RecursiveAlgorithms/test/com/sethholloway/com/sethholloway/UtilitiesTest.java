package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Test;


public class UtilitiesTest {
	
	@Test
	public void test_number_to_string_a() throws Exception {
		String output = Utilities.numberToString(1);
		System.out.println("Expecting A   ... Received " + output);
		assertEquals(output, "A");
	}

	@Test
	public void test_number_to_string_z() throws Exception {
		String output = Utilities.numberToString(26);
		System.out.println("Expecting Z   ... Received " + output);
		assertEquals(output, "Z");
	}

	@Test
	public void test_number_to_string_aa() throws Exception {
		String output = Utilities.numberToString(27);
		System.out.println("Expecting AA  ... Received " + output);
		assertEquals(output, "AA");
	}
	
	@Test
	public void test_number_to_string_ab() throws Exception {
		String output = Utilities.numberToString(28);
		System.out.println("Expecting AB  ... Received " + output);
		assertEquals(output, "AB");
	}
	
	@Test
	public void test_number_to_string_az() throws Exception {
		String output = Utilities.numberToString(52);
		System.out.println("Expecting AZ  ... Received " + output);
		assertEquals(output, "AZ");
	}
	
	@Test
	public void test_number_to_string_zz() throws Exception {
		String output = Utilities.numberToString(702);
		System.out.println("Expecting ZZ  ... Received " + output);
		assertEquals(output, "ZZ");
	}
	
	@Test
	public void test_number_to_string_bz() throws Exception {
		String output = Utilities.numberToString(78);
		System.out.println("Expecting BZ  ... Received " + output);
		assertEquals(output, "BZ");
	}	
	
	@Test
	public void test_number_to_string_ca() throws Exception {
		String output = Utilities.numberToString(79);
		System.out.println("Expecting CA  ... Received " + output);
		assertEquals(output, "CA");
	}
	
	@Test
	public void test_number_to_string_aaa() throws Exception {
		String output = Utilities.numberToString(703);
		System.out.println("Expecting AAA ... Received " + output);
		assertEquals(output, "AAA");
	}
	
}
