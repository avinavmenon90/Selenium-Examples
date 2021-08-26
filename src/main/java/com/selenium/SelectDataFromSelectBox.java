//Select data from select boxes on a web page

package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class SelectDataFromSelectBox {
	WebDriver driver;
	@Test
	
	public void selectDataFromSelectBox()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	
	WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]"));
	Select select = new Select(month);
	select.selectByValue("12");
	
	WebElement day = driver.findElement(By.xpath("//*[@id=\"day\"]"));
	select = new Select(day);
	select.selectByIndex(5);
	
	WebElement year = driver.findElement(By.xpath("//*[@id=\"year\"]"));
	select = new Select(year);
	select.selectByVisibleText("1956");
	
	}
}
