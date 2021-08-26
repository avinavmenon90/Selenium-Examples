package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {
	
	static WebDriver driver;
	
	public static void main (String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		
		
		  //Using Select class to choose dropdown value 
		Select select1 = new Select(driver.findElement(industry)); 
		select1.selectByVisibleText("India");
		  
		  Select select2 = new Select(driver.findElement(country));
		  select2.selectByVisibleText("country");
		  
		  
		  //to avoid writing multiple objects of Select class:
		  doSelectByVisibleText(country, "India"); doSelectByVisibleText(industry,
		  "Education");
		 
	
	//to call the combined-select method:
		doSelectDropDownValue(country,"index","17");
		doSelectDropDownValue(industry,"value","Education");

	}
	
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		
		Select select = new Select(getElement(locator)); //call getElement method
		
		select.selectByVisibleText(text);
	}

	
	public static void doSelectDropDownByIndex(By locator, int index) {
		
		Select select = new Select(getElement(locator)); //call getElement method
		
		select.selectByIndex(index);
	}
	
//for <option value="value">	
	public static void doSelectDropDownByValue(By locator, String value) {
		
		Select select = new Select(getElement(locator)); //call getElement method
		
		select.selectByValue(value);
	}
	
	
//all Select methods combined into one:	
public static void doSelectDropDownValue(By locator, String type, String value) {
		
		Select select = new Select(getElement(locator)); //call getElement method
		
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value)); //convert string into integer for index
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Please pass the correct selection criteria");
			break;
		}
		

		
	}

}
