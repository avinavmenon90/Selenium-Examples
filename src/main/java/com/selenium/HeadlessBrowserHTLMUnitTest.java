package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HeadlessBrowserHTLMUnitTest {

	@Test
	public void homePage() throws Exception {
	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://www.google.com"); //url to launch in headless mode
	        System.out.println("Page Title: "+page.getTitleText());
	        Assert.assertEquals("Google", page.getTitleText());
			
	        //Print page in XML format
			  final String pageAsXml = page.asXml();
			  System.out.println("Printing page as XML:"+"\n"+pageAsXml);
			  
	        //Print InnerText of the page
			  final String pageAsText = page.asText();
			  System.out.println("Printing page as InnerText:"+"\n"+pageAsText);
			 
	    }
	}
	
	
	@Test //testing using Selenium WebDriver
	public void googleTest() {
	
	//Generic headless mode	
		WebDriver driver = new HtmlUnitDriver();
		
	//headless mode	with Chrome
		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME); 
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
	//Perform google search
		driver.findElement(By.xpath("//input[(starts-with(@class,'gLFyf'))]")).sendKeys("tokyo 2020");
		driver.findElement(By.className("gNO89b")).click();
		
		System.out.println("Current page title: "+driver.getTitle());
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
	}
}
