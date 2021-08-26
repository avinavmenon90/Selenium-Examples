package com.selenium;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PrintAllDataFromWebTable {
	WebDriver driver;
	
	@Test //define as a TestNG test
	public void enterText() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		
		driver = new ChromeDriver();
		
		//site URL
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		//put a 30 second delay to 'implicitly wait' for the entire page to be loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//number of rows in table
		int rowsNumber= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		System.out.println("Number of rows in table: "+rowsNumber);
		
		//number of columns in table
		int colsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		System.out.println("Number of columns in table: "+colsNumber);
		
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr["; //to iterate through rows
		String secondPart = "]/td["; //to interate through columns
		String thirdPart = "]";
		
		for(int i=1;i<rowsNumber;i++) {
			
			for(int j=1;j<=colsNumber;j++) {
				
				String finalPart = firstPart+i+secondPart+j+thirdPart;
				//System.out.println(finalPart);
				System.out.print(driver.findElement(By.xpath(finalPart)).getText()+" | "); //print all table contents
			}
			
			System.out.println(); //newline after every column
		}
			
	}
}
