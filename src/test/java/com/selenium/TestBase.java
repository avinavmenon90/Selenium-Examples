package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver=null;
	public static String browser = "chrome";
	
	public static void initialize() {
		
		//singleton pattern
			if(driver==null){
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				
			}
			
			driver.manage().window().maximize(); //maximize browser window
			driver.manage().deleteAllCookies(); //delete all cookies
			
			//dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//ExplicitlyWait example
				//WebDriverWait wait = new WebDriverWait(driver, 10);
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));
			
			//goto URL
			driver.get("http://google.com");
	}
	
	public static void tearDown() {
		
		driver.quit();
		
	//set driver obj to NULL so that it will be re-initialized by the next Test method
		driver=null;
	}

}
