package com.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBrokenLinksAndImagesTest {

	private static WebDriver driver;
	static HttpURLConnection connection;
	static String responseMessage;
	static long sTime, eTime;
	
	
	public static void main(String[] args) throws IOException,MalformedURLException {
		/*
		 * Checking for Broken Links or Broken Images using Selenium
		 */
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
				//goto URL
				driver.get("https://www.apple.com/");
				
				//links always have <a> tag and href property
				//images always have <img> tag and href property
				
				//1. get list of all links and images
					List<WebElement> linksList = driver.findElements(By.tagName("a")); //add ALL <a> tags
					linksList.addAll(driver.findElements(By.tagName("img"))); //add ALL <img> tags to the same list
					
					//total size of linksList list
					System.out.println("# of ALL links and images: "+linksList.size());
					
				//2. get ALL links which have an href property 
					List<WebElement> activeLinks = new ArrayList<WebElement>();
					
					for(int i=0;i<linksList.size(); i++) {
						//print each href in console
						//System.out.println(linksList.get(i).getAttribute("href"));
						
						//igore hrefs that are null
						//and
						//ignore hrefs that contain 'javascript' word
						if(linksList.get(i).getAttribute("href") != null && ( ! linksList.get(i).getAttribute("href").contains("javascript"))){ 
							//System.out.println("Active Link #"+(i+1)+":"+linksList.get(i).getText());
							activeLinks.add(linksList.get(i)); //only active links are added in the list
						}
					}
					
				//3. get size of activeLinks list:
					System.out.println("# of active links and images: "+activeLinks.size());
					
				//4. check href URL with httpconnection API
		
					
					  for(int j=0; j<activeLinks.size(); j++) {
					  
					  System.out.println("Link #"+(j+1)+":"+activeLinks.get(j).getAttribute("href")
					  );
					  
					  //use URL class obj and cast it as HttpURLConnection obj //HttpURLConnection
					  //gives HTTP features 
					  connection = (HttpURLConnection)new
					  URL(activeLinks.get(j).getAttribute("href")).openConnection();
					  
					  //set connection timeout //connection.setConnectTimeout(5000);
					  
					  //connect with specific URL connection.connect();
					  
					  //check response code returned 
					  //200 --OK 
					  //400 --not found 
					  //500 --internal  error 
					  //400 --bad request responseMessage = connection.getResponseMessage();
					  
					  if(connection.getResponseCode() >= 400) {
					  System.out.println(activeLinks.get(j).getAttribute("href")+"-->"+
					  responseMessage+"is a broken link"); } else
					  System.out.println(activeLinks.get(j).getAttribute("href")+"-->"+
					  responseMessage);
					  
					  //disconnect connection connection.disconnect();
					  
					  }
		 	
					
				//5. Alternate method to check each URL in the list using parallelStream() and Lambda function - JAVA 8 or above
					List<String> urlList = new ArrayList<String>();
					for (WebElement e: activeLinks) {
						String url = e.getAttribute("href");
						urlList.add(url);
					}
					
					//using parallelStream method to open multiple streams and check the URL
					//use Lambda (->) to iterate through each link
					sTime = System.currentTimeMillis(); //start time of opening the 1st link
					urlList.parallelStream().forEach(e -> checkBrokenLink(e)); //parallel stream
					//urlList.stream().forEach(e -> checkBrokenLink(e)); //sequential stream
					eTime = System.currentTimeMillis(); //endtime of opening the last link
					
					
					//Total time taken: 12.825s (parallel stream)
					//Total time taken: 43.566s (sequential stream - takes much longer)
					System.out.println("Total time taken: "+ (eTime-sTime)); 

					
					driver.quit();
	}
	
	public static void checkBrokenLink(String linkURL) {
		
					try {
						URL url = new URL(linkURL);
						connection = (HttpURLConnection) url.openConnection(); //HTTPURLConnection is super class of URL
						connection.setConnectTimeout(5000);
						connection.connect();
						responseMessage = connection.getResponseMessage();
						
						if(connection.getResponseCode() >= 400) { // >= 400 is a bad URL
							System.out.println((linkURL)+"-->"+responseMessage+"is a broken link");
						}
						else
							System.out.println((linkURL)+"-->"+responseMessage);
						
						//disconnect connection
						connection.disconnect();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
		
	}

}
