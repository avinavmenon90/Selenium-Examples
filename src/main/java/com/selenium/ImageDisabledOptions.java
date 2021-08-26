package com.selenium;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ImageDisabledOptions {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
//		ChromeOptions options= new ChromeOptions();
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Avinav\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		
	//Hide images on the page by calling the method	(Firefox)
		disableImageFirefox(options);
		
	//Hide images on the page by calling the method	(Chrome)
		//disableImageChrome(options);
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		
		System.out.println(driver.getTitle());
	}

	
	public static void disableImageChrome(ChromeOptions options) {
		
		//HashMap<String, Object> images = new HashMap<String, Object>();
		
	//write into HashMap	
		//images.put("images",2);
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
	
	//configs provided by Google Chrome	
		prefs.put("profile.managed_default_content_settings.images", 2);
		
		options.setExperimentalOption("prefs", prefs);
		
		Object checking = options.getExperimentalOption("prefs");
		
		System.out.println(checking.toString());
	}
	
	public static void disableImageFirefox(FirefoxOptions options) {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
	}

}
