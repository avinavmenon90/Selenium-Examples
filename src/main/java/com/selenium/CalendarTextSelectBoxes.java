package com.selenium;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CalendarTextSelectBoxes {
	WebDriver driver;
	
	String cimonth="November 2019";
	String comonth = "December 2019";
	String checkinDate= "22";
	String checkoutDate= "31";
	
	@Test //define as a TestNG test
	public void caltxtSelect() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		
		//Get rid of cookie disclaimer
		driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
		Thread.sleep(1000);
		
		//Click on Hotels text box
		//driver.findElement(By.xpath("//*[@id='s2id_autogen3']/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='s2id_location']/a/span[1]")).click();
		Thread.sleep(1000);
		
		//Write 'Block' in text box
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Block");
		Thread.sleep(5000); //wait for next month to load
		
		//get all search results that show up into a WebElement list
		List<WebElement> data = driver.findElements(By.xpath("//ul[@class='select2-result-sub']/li"));
				
		//iterate through each WebElement
		for(int i=0;i<data.size();i++)
		{
			WebElement element = data.get(i);
			String text=data.get(i).getText();
			//checking the text returned 
			System.out.println(text);
			if(text.equals("Block Island, United States")){
				element.click();
				System.out.println("Block island clicked");
				break;
			}
		}
		
/***********		Select date from Calendar        **********/
		
		/***********  Check-in Date     **********/
		//get check-in month text of current page to compare with defined month
		WebElement clickcheckinmonth = driver.findElement(By.xpath("//*[@id='dpd1\']/div/input"));
		clickcheckinmonth.click(); //clicking the check-in box
		WebElement checkinMonth= driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][4]/div[1]/table/thead/tr[1]/th[2]"));
		System.out.println("Checkin month text: "+checkinMonth.getText());
		//System.out.println("Checkin month enabled? "+checkinMonth.isEnabled());
		//System.out.println("Checkin month displayed? "+checkinMonth.isDisplayed());
		//System.out.println("Checkin month selected? "+checkinMonth.isSelected());
					
		while(true)
			{		if(checkinMonth.getText().equals(cimonth)) {
					break;}
					else {
						//go to next month by clicking on 'next' button
						WebElement next = driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][4]/div[1]/table/thead/tr[1]/th[3]"));
						//System.out.println("Next button enabled? "+next.isEnabled());
						//System.out.println("Next button displayed? "+next.isDisplayed());
						//System.out.println("Next button selected? "+next.isSelected());
						//System.out.println("Next button text: "+next.getText());
						next.click();
						Thread.sleep(1000); //wait for next month to load
					}
					
			}
		
		//enter check-in date variable from above and click
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][4]/div[1]/table/tbody/tr[4]/td[contains(text(),'"+checkinDate+"')]")).click();		
	
		
		/***********  Check-out Date     **********/
		//WebElement clickcheckoutmonth = driver.findElement(By.xpath("//*[@id='dpd2']/div/input"));
		//System.out.println("clickcheckoutmonth month enabled? "+clickcheckoutmonth.isEnabled());
		//System.out.println("clickcheckoutmonth month displayed? "+clickcheckoutmonth.isDisplayed());
		//System.out.println("clickcheckoutmonth month selected? "+clickcheckoutmonth.isSelected());
		//Thread.sleep(1000);
		//clickcheckoutmonth.click(); //clicking the check-in box
		//Thread.sleep(1000);
		//get check-out month text of current page to compare with defined month
		WebElement checkoutMonth= driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div[1]/table/thead/tr[1]/th[2]"));
		//System.out.println("Checkout month enabled? "+checkoutMonth.isEnabled());
		//System.out.println("Checkout month displayed? "+checkoutMonth.isDisplayed());
		//System.out.println("Checkout month selected? "+checkoutMonth.isSelected());
		//System.out.println("Checkout month text: "+checkoutMonth.getText());
		//Thread.sleep(1000);
		
		while(true)
		{
				if(checkoutMonth.getText().equals(comonth)) {
					//System.out.println("inside if of while loop");
				break;}
				else {
					//System.out.println("inside else of while loop");
					//go to next month by clicking on 'next' button
					driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div[1]/table/thead/tr[1]/th[3]")).click();
					Thread.sleep(1000); //wait for next month to load
				}
				
		}
				//enter check-out date variable from above and click
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div[1]/table/tbody/tr[6]/td[contains(text(),'"+checkoutDate+"')]")).click();
		//Thread.sleep(1000);
	
		/***********  Number of Adults     **********/
		WebElement adults = driver.findElement(By.xpath("//*[@id='htravellersInput']"));
		
		//click
		adults.click();
		
		//number of adults
		WebElement numadults = driver.findElement(By.xpath("//*[@id='hadultInput']"));
		
		//numadults.click();
		
		//choose number of adults
		numadults.clear();
		numadults.sendKeys("5");
		
		//number of children
		WebElement numchildren = driver.findElement(By.xpath("//*[@id='hchildInput']"));
				
		//choose number of children
		numchildren.clear();
		numchildren.sendKeys("1");
		
		
		//Search Button
		driver.findElement(By.xpath("//*[@id='thhotels']/form/div[5]/button")).click();
	
	
	
	}
}
