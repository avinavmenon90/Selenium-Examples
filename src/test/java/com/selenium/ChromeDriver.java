package com.selenium;

import com.selenium.utils.WebDriver;

public class ChromeDriver implements WebDriver {
	
//Constructor	
	public ChromeDriver() {
		
		System.out.println("launch Chrome browser");
	}
	

	public void get(String url) {
		
		System.out.println("launch URL: "+url);
	}

	public void findElement(String locator) {
		
		System.out.println("finding element "+locator);
	}

	public void close() {
	System.out.println("Close browser");
		
	}

	public void quit() {
		System.out.println("Quit the browser");
		
	}

}
