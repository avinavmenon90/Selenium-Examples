package com.selenium;

import com.selenium.utils.WebDriver;

public class FirefoxDriver implements WebDriver {

//constructor
	public FirefoxDriver() {
		
		System.out.println("launch FF browser");
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


		System.out.println("Q browser");
		
	}

}
