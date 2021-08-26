package com.selenium.utils;

public interface WebDriver {
	
//Interface methods (don't have a method body)	
	public void get(String url);
	public void findElement(String locator);
	public void close();
	public void quit(); 

}
