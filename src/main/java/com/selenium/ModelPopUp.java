package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModelPopUp {

	public static void main(String[] args) throws InterruptedException {

		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\Avinav\\Downloads\\chromedriver.exe"); WebDriver driver = new
		  ChromeDriver();
		  
		  driver.manage().window().maximize(); //maximize browser window
		  driver.manage().deleteAllCookies(); //delete all cookies
		 		
		//dynamic wait
		
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		//goto URL
		driver.get("http://automationpractice.com/");
		
	//Model Popup is in a frame (iFrame)
	//swtich to the frame
		driver.switchTo().frame("frame-name");
	//wait a few secs for the pop-up to come up
		Thread.sleep(3000);
		
	//mouse-over to the frame
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'class-name-here')]"))).build().perform();
		
	//now, find xpath of X icon and click it
		driver.findElement(By.xpath("//div[contains(@class,'class-name-here')]//span")).click();
		
		

	}

}
