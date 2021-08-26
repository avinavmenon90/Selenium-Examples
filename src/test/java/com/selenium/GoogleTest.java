package com.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

	
	@BeforeMethod
	public void setup() {
		
		TestBase.initialize();
	}
	
	@Test(priority=1,groups="Title")
	public void googleTitleTest() {
		
		String title = TestBase.driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2,groups="Logo")
	public void googleLogoTest() {
		
		boolean googleLogoDisplayed = TestBase.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		
	}
	
	@Test(priority=3,groups="Link Text")
	public void gmailLinkTest() {
		
		boolean gmailLinkDisplayed = TestBase.driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
	}
	
	@Test(priority=4,groups="Link Text")
	public void signInLinkTest() {
		
		boolean signInLinkDisplayed = TestBase.driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
	}
	
	
	@Test(priority=5,groups="Logo")
	public void signInLogo() {
		
		boolean signInLogoDisplayed = TestBase.driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
	}
	
	
	@Test(priority=6,groups="Title")
	public void gmailTitleTest() {
		
		String gmailTtitle = TestBase.driver.getTitle();
		System.out.println(gmailTtitle);
	}
	
	
	@AfterMethod
	public void quit() {

		TestBase.tearDown();
	}
	
}
