package com.selenium;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class GetAllLinksInSite {

WebDriver driver;
	
	@Test //define as a TestNG test
	public void enterText() throws InterruptedException, ParseException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		
		driver = new ChromeDriver();
		
		//site URL
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		//put a 30 second delay to 'implicitly wait' for the entire page to be loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//get a list of ALL anchor tags on site
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of a tags on page: "+links.size());
		for (int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			
			driver.quit();
		}
		
	}
}
