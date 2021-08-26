package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumQandA {

	WebDriver driver = new FirefoxDriver();
	
	//get all Window IDs on the page
	Set<String> windowsId = driver.getWindowHandles(); //'Set' class allows only unique values
	
	//iterate through each id
	Iterator<String> itr = windowsId.iterator();
	
	//store all ids into an Array
	ArrayList<String> ids = new ArrayList<String>();
	//while loop
			
	while(itr.hasNext()) {
		ids.add(itr.next());
	}
	
	//go to 3rd window
	driver.switchTo().window(ids.get(2));
	
	//check if element is present on 3rd window
	drive.findElement(By.xpath("")).isDisplayed();
	
	driver.close(); //3rd window closed
	
	//switch to 2nd window
	driver.switchTo().window(ids.get(1));
	
	//close 2nd window
	driver.close();
	
	//go to parent window
	driver.switchTo().window(ids.get(0));
}
