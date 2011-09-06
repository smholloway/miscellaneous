package com.sethholloway;

public class Fibonacci {
	private long sequence = 0;
	
	public Fibonacci() {
	}
	
	public Fibonacci(int n) {
		sequence = fib(n);
	}
	
	public long getSequence() {
		return sequence;
	}
	
	public static long fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}

}
