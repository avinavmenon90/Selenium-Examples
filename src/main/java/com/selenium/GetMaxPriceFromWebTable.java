package com.selenium;
import java.util.List;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
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

import edu.emory.mathcs.backport.java.util.Collections;


public class GetMaxPriceFromWebTable {

	WebDriver driver;
	
	@Test //define as a TestNG test
	public void enterText() throws InterruptedException, ParseException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		
		driver = new ChromeDriver();
		
		//site URL
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		
		//put a 30 second delay to 'implicitly wait' for the entire page to be loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> rows= driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		int rowData = rows.size();
	
		
		//WebElement currentPrice = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
		
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart= "]/td[4]";
		ArrayList<Integer> priceArray = new ArrayList<Integer>();
		
		for(int i=1;i<rowData;i++) {
			
			String finalPart = firstPart+i+secondPart; // construct xpath on runtime dynamically
			String price = driver.findElement(By.xpath(finalPart)).getText();
			//Double  = Double.parseDouble(price); //Wrapper class for parsing String to Double
			//priceArray.add(dPrice);
			
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			Number num = numberFormat.parse(price);
			price = num.toString();
			Double dPrice = Double.parseDouble(price);
			int intPrice = dPrice.intValue();
			priceArray.add(intPrice);
			
		}
		
		Collections.sort(priceArray); 
		System.out.println("Highest price is: "+priceArray.get(priceArray.size()-1));
	}
	
}
