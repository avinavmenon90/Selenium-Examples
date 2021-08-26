package com.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	//@Before: pre-conditions
	//Execution Order:
	
	//1.
	@BeforeSuite
	public void setup() {
		System.out.println("setup sys property for browser");
	}
	
	//2.
	@BeforeTest
	public void launcbBrowser() {
		System.out.println("launch browser");	
	}
	
	//3.
	@BeforeClass
	public void login() {
		System.out.println("log in to app");
	}
	
	//Sequence:
	/* @BeforeMethod
	 * @Test - 1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test - 2
	 * @AfterMethod
	 */
		
	//4.
	@BeforeMethod
	public void enterURL() {
		System.out.println("enter URL");
	}
	
	//5.
	//@Test: test case
	@Test
	public void googleTitleTest() {
		System.out.println("Google title Test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Search test");
	}
	
	//6.
	//@After: post-conditions
	@AfterMethod
	public void logOut() {
		System.out.println("logout");
	}
	
	//7.
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	//8.
	@AfterTest
	public void deleteAllCookikes() {
		System.out.println("delete all cookies");
	}
	
	//9.
	@AfterSuite
	public void generateTestReport() {
		System.out.println("generate test report");
	}
}
