//Enter data in ONE text box on a web page

package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example1 {
	
	WebDriver driver;
	
	@Test
	public void enterDataInTextField() {
		//System.setProperty should be defined BEFORE driver= mew ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
	}

}
