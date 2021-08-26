//Enter data in MULTIPLE text boxes on a web page

package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WriteToMultipleTexBoxes {
	
	WebDriver driver;
	@Test
	public void enterTextMultipleFields() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("FirstName");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("LastName");
		driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("test12@hotmail.com");
		
	}

}
