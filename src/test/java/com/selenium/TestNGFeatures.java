package com.selenium;

import org.testng.annotations.Test;

public class TestNGFeatures {

	
	@Test
	public void loginTest() {
		System.out.println("login");
		int i = 9/0;
		System.out.println(i);
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("home page test");
	}
}
