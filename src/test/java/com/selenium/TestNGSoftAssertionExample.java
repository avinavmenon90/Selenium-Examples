package com.selenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoftAssertionExample {

	SoftAssert softAssert = new SoftAssert(); //class in TestNG
	
	@Test
	public void softAssert() {
		System.out.println("open browser");
		
		Assert.assertEquals(true, false); //hard assertion fails, so all lines below are skipped and TC marked as failed
		
		System.out.println("go to URL");
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click on sign in button browser");
		
		Assert.assertEquals(true, false);//hard assertion
		
		System.out.println("validate Home Page");
		softAssert.assertEquals(true, false,"Home Page title doesn't match");//soft assertion (won't fail the TC and goes to next step)
		
		System.out.println("go to deal page");
		System.out.println("create a deal");
		softAssert.assertEquals(true, false, "unable to create a deal");//soft assertion
		
		System.out.println("go to contact page");
		System.out.println("create a contact");
		softAssert.assertEquals(true, false);//soft assertion
		
		softAssert.assertAll(); //checks assertion on all failed soft assertions and then marks TC as failed (although all TC steps are executed)
		
	}
}

