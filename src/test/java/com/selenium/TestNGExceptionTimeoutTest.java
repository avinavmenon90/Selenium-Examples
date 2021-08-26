package com.selenium;

import org.testng.annotations.Test;

public class TestNGExceptionTimeoutTest {

	
	@Test(invocationTimeOut=2000) //in milliseconds
	public void infiniteLoopTest() {
		int i = 1;
		while(i==1) {
			System.out.println(i);
		}
	}
	
	@Test(expectedExceptions=NumberFormatException.class) //expecting an exception
	public void expectedExceptionsTest() {
		String x="100A";
		Integer.parseInt(x);
		}
}
