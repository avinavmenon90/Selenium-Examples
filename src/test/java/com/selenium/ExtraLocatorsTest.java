package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraLocatorsTest {
	
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//goto URL
		driver.get("https://www.facebook.com");
	
		/* ByAll: class contains ALL possible By locators
		 * By locators will be searched in the left-to-right order (By.name, then By.id then By.xpath)
		 */ 
		driver.findElement(new ByAll(By.name("firstname"), By.id("u_0_j"), By.xpath("//input[@name='firstname']"))).sendKeys("tomhardy891");
		
	//ByIdOrName:  check for matching <id> or <name> attribute	
		driver.findElement(new ByIdOrName("firstname")).sendKeys("tomhardy891");
		
		driver.quit();
		
		
	/* ByChained: Parent-child chaining is used
	 */
		driver.findElement(new ByChained(By.id("u_0_j"), By.xpath("//div[@class='classname here']"), By.name("firstname"))).sendKeys("tomhardy891");

	}

}
