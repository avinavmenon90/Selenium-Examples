//Mouse Over a menu using Selenium

package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MouseOverOnWebPage {
	WebDriver driver;
	@Test
	
	public void mouseOver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.actitime.com/");
		
		WebElement features = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[2]/a"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(features).build().perform();
	}
	
}
