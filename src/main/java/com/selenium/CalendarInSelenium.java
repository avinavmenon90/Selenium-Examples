package com.selenium;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CalendarInSelenium {
	WebDriver driver;
	
	
	String month="November 2019";
	String date= "22";
	@Test //define as a TestNG test
	
	public void calendarSelenium() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		
		driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).click();
		
		//get month text of current page to compare with defined month
		WebElement mon= driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[2]"));
		
		//click on a date
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr[4]/td[contains(text(),'')]")).click();
		
		while(true)
		{
			if(mon.getText().equals(month)) {
			break;}
			else {
				//go to next month by clicking on 'next' button
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000); //wait for next month to load
			}
			
		}
		
		//enter date variable from above
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr[5]/td[contains(text(),'"+date+"')]"));
		
	}
	
}
	
	
