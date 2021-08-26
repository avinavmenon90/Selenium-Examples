package com.selenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapInSelenium {
	
	public static String credentials;
	static WebDriver driver;

	public static void main(String[] args) {
		
//Role based or permission based use cases
		//customer  -> go to app -> buy a product -> place order
		//admin  -> go to app -> see all products
		//Seller -> go to app -> see only relevant orders 
		//distributor -> go to app -> see the respective order
		//delivery boy -> go to app -> see relevant order and deliver product
		//category manager user -> go to app -> add all products
		//customer care -> go to app -> see all user orders
		
//calling credentials method
		getCredentialsMap();
		System.out.println(getCredentialsMap());
		
		System.out.println("distributor details --> "+getCredentialsMap().get("distributor"));
		
//Launch browser	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
	//extract username from credentials_customer and pass it to sendKeys	
		driver.findElement(By.id("email")).sendKeys(getUserName("customer"));
		
	//extract password from credentials_customer and pass it to sendKeys
		driver.findElement(By.id("pass")).sendKeys(getPassword("customer"));
		
	//click on login button
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	
	public static HashMap<String, String>  getCredentialsMap() {
		
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "avi:test@123");
		userMap.put("admin", "mavi:test@234");
		userMap.put("seller", "ravi:test@345");
		userMap.put("distributor", "kavi:test@456");
		userMap.put("deivery", "shavi:test@567");
		userMap.put("category manager", "bavi:test@678");
		userMap.put("customer care", "havi:test@789");
		
		return userMap;
		
	}

	public static String getUserName(String role) {
		
		credentials = getCredentialsMap().get(role);
		return credentials.split(":")[0];
		
	}
	
	public static String getPassword(String role) {
		
		credentials = getCredentialsMap().get(role);
		return credentials.split(":")[1];
		
	}
}
