package com.selenium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//specify annotation @Listeners to move to the CustomListener class and execute from there
@Listeners(CustomListener.class)
public class FailedTestScreenshot extends Base {
	
	@BeforeMethod
	public void setUp() {
		
	//calling method in Base class to initialize chromedriver	
		initialization();
	}

	
	@AfterMethod
	public void tearDown() {
		
			driver.quit();
	}
	
	
	@Test
	public void takeScreenshotTest() {
		
	//forcing a failed test case to take screenshot	
		Assert.assertEquals(false, true);
		
	}
}
