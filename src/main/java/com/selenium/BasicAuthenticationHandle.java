package com.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class BasicAuthenticationHandle {
	
	
	static ChromeDriver driver;
//	private static final String username = "admin";
//	private static final String password = "admin";
	
	
	public static void main(String[] args) throws IOException, InterruptedException {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(2000);
//Runtime: method used to run the AutoIt compiled exe file		
		Runtime.getRuntime().exec("C:\\Users\\Avinav\\Documents\\authenticate.exe");
		
		Thread.sleep(2000);

	}

}
