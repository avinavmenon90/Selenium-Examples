package com.selenium;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.utils.TestUtil;

public class TestNGDataProviderExample {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "location of cd.exe");
		driver = new ChromeDriver();
		driver.get("url");
	}

	@DataProvider
	public Iterator<Object[]> getExcelData() {

	//call static method in TestUtil class to fetch data from Excel
		ArrayList<Object[]> excelData= TestUtil.getDataFromExcel();
		
	//call iterator() method to iterate each arraylist element in sequence	
		return excelData.iterator();
	}
	
//pass same #parameters in TestNG method as the #columns in the excel	
//dataProvider: fetches the ArrayList of data and passes it one-at-a-time to the Test Case
//# of excel data rows will equal the # of times the TC is executed
	@Test(dataProvider ="getExcelData")
	public void GoogleRegistrationPage(String firstname,String lastname,String address1,String address2,String city,String state,String zip,String email) {
		
	//data to enter on the page form:
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("");
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("");
		
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys("");
		
		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys("");
		
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("");
		
//State: dropdown selection	
		Select select = new Select(driver.findElement(By.id("state")));
		select.selectByVisibleText("");
				
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("zip")).sendKeys("");
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
	
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
	

}
