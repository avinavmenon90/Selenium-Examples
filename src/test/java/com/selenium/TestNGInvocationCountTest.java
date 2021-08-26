package com.selenium;

import org.testng.annotations.Test;

public class TestNGInvocationCountTest {

	/*
	 * Re-run same test multiple times
	 */
	
	@Test(invocationCount=10)
		public void sum() {
			int a = 10;
			int b = 20;
			System.out.println(a+b);
		}
}
	

