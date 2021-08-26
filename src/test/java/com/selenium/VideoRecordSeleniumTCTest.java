package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.utils.MyScreenRecorder;

public class VideoRecordSeleniumTCTest {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Test
	public void navigationTest() throws Exception {
		
	//call MyScreenRecorder class method to start recording	
	//pass desired name for the recording as a parameter to the method	
		MyScreenRecorder.startRecording("navigationTest");
		
		
		
		driver.get("http://www.google.com/");
		
		driver.navigate().to("http://www.facebook.com/");
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		
	//call MyScreenRecorder class method to stop recording	
		MyScreenRecorder.stopRecording();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}
