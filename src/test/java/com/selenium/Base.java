package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	
		public static WebDriver driver;
		
		public static void initialization() {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize(); //maximize browser window
			driver.manage().deleteAllCookies(); //delete all cookies
			
			//dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//goto URL
			driver.get("http://google.com");
		}
		
	//method to take screenshot and store it in a file	
		public void failed(String testMethodName) {
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("C:\\Users\\Avinav\\eclipse-workspace\\selenium\\test-output\\"+testMethodName+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
