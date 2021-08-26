package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarHandlingGenericCode {

	static ChromeDriver driver;
	static String monthAndYear;
	static String month;
	static String year;
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		selectDate("29", "February", "2023");
	}
	
//Method to split month and year	
	public static void getMonthYear() {
		
	 monthAndYear = driver.findElement(By.className("ui-datepicker-title")).getText();
	 month = monthAndYear.split(" ")[0].trim();
	 year = monthAndYear.split(" ")[1].trim();
	}
	
//Generic method to select a date	
	public static void selectDate(String expDay, String expMonth, String expYear) {
		
driver.findElement(By.id("datepicker")).click();
		
//wait for the calendar to be visible on the screen 
		new WebDriverWait (driver, 5)
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
			
		if(((expMonth.equalsIgnoreCase("February")) && (Integer.parseInt(expDay)>28)) || ((Integer.parseInt(expDay)>28))){
			System.out.println("Please enter a valid date");
			driver.quit();
			return;
		}
		else {
			//call function to split month and year	
			getMonthYear();
		
		while(!(month.equalsIgnoreCase(expMonth) && year.equalsIgnoreCase(expYear))) {
			
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			getMonthYear();	
			System.out.println(monthAndYear);
			
			
		}
		
		driver.findElement(By.linkText(expDay)).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Date picked: "+driver.findElement(By.xpath("//input[@id='datepicker']")).getText());
	

		}
		
	}
	
}