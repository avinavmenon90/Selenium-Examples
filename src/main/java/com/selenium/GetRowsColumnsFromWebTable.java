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

public class GetRowsColumnsFromWebTable {

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
			
			int rowsNumber= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
			System.out.println("Number of rows in table: "+rowsNumber);
			
			int colsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
			System.out.println("Number of columns in table: "+colsNumber);
			
			//value of a particular field - for FIXED ROWS 
			String rowData = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[3]")).getText();
			
			//for DYNAMIC ROWS, use parent and following-sibling concept
			rowData = driver.findElement(By.xpath("//a[contains(text(),'Jamna Auto Inds.')]/parent::*/following-sibling::td[3]")).getText();
			System.out.println("data of row is: "+rowData);
			
		}
		
}
