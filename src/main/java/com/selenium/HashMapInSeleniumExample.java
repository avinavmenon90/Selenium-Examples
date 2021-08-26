package com.selenium;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapInSeleniumExample {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//goto URL
		driver.get("http://google.com");
		
		
		HashMap<String, String> users = getUserLoginInfo();
		
		String customerCredentials = users.get("customer");
		
		String customerInfo[] = customerCredentials.split("_");
		
		driver.findElement(By.xpath("xpath of username")).sendKeys(customerInfo[0]);
		
		driver.findElement(By.xpath("xpath of password")).sendKeys(customerInfo[1]);
		
		//HashMap<Integer, String> months = monthMap();
	
	}
	
	public static HashMap getUserLoginInfo() {
		
		HashMap<String, String> userMap = new HashMap<String, String>();
		
	//storing username and password separated by '_'	
		userMap.put("customer", "tomhardy_123");
		userMap.put("admin", "humphrey_456");
		
		return userMap;
		
		
	}
	
	public static HashMap monthMap() {
	
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		
		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3, "March");
		monthMap.put(4, "April");
		monthMap.put(5, "May");
		monthMap.put(6, "June");
		
		
		return monthMap;
		
		
	}


}
