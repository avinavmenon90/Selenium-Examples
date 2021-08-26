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

public class WindowHandleConcepts {
	WebDriver driver;
	
	@Test //define as a TestNG test
	
	public void windowHandle()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinav\\eclipse-workspace\\selenium\\drivers\\chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		//click on Youtube link
		driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[3]/a")).click();
		
		//get all IDs for all windows (initial window and new window after click)
		Set<String> windowsId = driver.getWindowHandles();
		
		//going through Iterator through each window ID
		Iterator<String> itr = windowsId.iterator();
		
		String parentId = itr.next(); //1st window ID
		String childId = itr.next(); //2nd window ID
		
		//switch to youtube window
		driver.switchTo().window(childId);
		
		//putting a delay of 3 seconds to confirm child window opened and closed
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close child
		driver.close();
		
		//back to parent window
		driver.switchTo().window(parentId); 
		
		//click on 'Women' link
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
		
	}

}