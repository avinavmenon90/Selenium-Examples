//Mouse Over a menu using Selenium and Clikc on a particular link

package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MouseOverAndClickLink {
	WebDriver driver;
	@Test
	
	public void mouseOverClickLink()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/");
		
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(features).build().perform();
		
		//putting a delay of 1 second (1000ms) to confirm mouse over was successful
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("Workflow Adjustment")).click();
	}
}
