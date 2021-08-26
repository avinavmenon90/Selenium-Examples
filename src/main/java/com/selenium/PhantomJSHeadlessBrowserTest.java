package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSHeadlessBrowserTest {

	public static void main(String[] args) {

	 //set key-value pair for PhantomJS: value is path to PhantomJS.exe file downloaded in local
		System.setProperty("phantomjs.binary.path","C:\\Users\\Avinav\\Documents\\PhantomJS 2.1.1\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		WebDriver driver = new PhantomJSDriver();
		
		driver.get("http://www.google.com");
	
		String pageTitle = driver.getTitle();
		
		System.out.println("page title: "+pageTitle);

	}

}
