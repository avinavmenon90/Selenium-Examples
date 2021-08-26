package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SendKeysCharSequence {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		
	//1. String	
		//email.sendKeys("avi@gmail.com");
		
//	//2. Array of Strings
//		StringBuilder username = new StringBuilder().append("Avi").append(" ").append("Testing").append(" ").append("Strings");
//		
//		email.sendKeys(username);
//		
//		Thread.sleep(20000);
//		
//		driver.quit();
		
		
	//3. String Buffer
		
//		StringBuffer username = new StringBuffer().append("Avi").append(" ").append("Testing").append(" ").append("Strings");
		
//		email.sendKeys(username);
//		
//		Thread.sleep(20000);
//		
//		driver.quit();
		
	//3. String Builder, String Buffer, String, Keys	
		
		StringBuilder username = new StringBuilder().append("Avi").append("Testing").append("Strings");
		
		String space = " ";
		
		StringBuffer userInfo = new StringBuffer().append("Test").append("WebDriver");
		
		String author = "Avinav Menon";
		
		email.sendKeys(username, space, userInfo, author, Keys.TAB); //Keys.TAB: tab out of the current field and into the next field 
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
