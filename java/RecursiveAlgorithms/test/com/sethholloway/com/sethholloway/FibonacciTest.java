package com.sethholloway;

import static org.junit.Assert.*;

import org.junit.Test;


public class FibonacciTest {
	
	@Test
	public void test_fib_with_constructor() throws Exception {
		Fibonacci fib = new Fibonacci();
		assertEquals(fib.getSequence(), 0);
	}
	
	@Test
	public void test_fib_one_with_constructor() throws Exception {
		Fibonacci fib = new Fibonacci(1);
		assertEquals(fib.getSequence(), 1);
	}
	
	@Test
	public void test_fib_one() throws Exception {
		assertEquals(Fibonacci.fib(1), 1);
	}

	@Test
	public void test_fib_two() throws Exception {
		assertEquals(Fibonacci.fib(2), 1);
	}
	
	@Test
	public void test_fib_three() throws Exception {
		assertEquals(Fibonacci.fib(3), 2);
	}
	
	@Test
	public void test_fib_four() throws Exception {
		assertEquals(Fibonacci.fib(4), 3);
	}
	
	@Test
	public void test_fib_five() throws Exception {
		assertEquals(Fibonacci.fib(5), 5);
	}
	
	@Test
	public void test_fib_six() throws Exception {
		assertEquals(Fibonacci.fib(6), 8);
	}
	
	@Test
	public void test_fib_seven() throws Exception {
		assertEquals(Fibonacci.fib(7), 13);
	}
	
	@Test
	public void test_fib_eight() throws Exception {
		assertEquals(Fibonacci.fib(8), 21);
	}
	
	@Test
	public void test_fib_nine() throws Exception {
		assertEquals(Fibonacci.fib(9), 34);
	}
	
	@Test
	public void test_fib_ninety() throws Exception {
		//stack overflow
		assertEquals(Fibonacci.fib(90), 34);
	}

}
