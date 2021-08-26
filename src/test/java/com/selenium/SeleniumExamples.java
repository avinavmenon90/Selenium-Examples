package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.Pattern;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.Screen;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class SeleniumExamples {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//goto URL
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		/*Handling File upload in Selenium
		 * Browse button for fileupload
		 */
		driver.findElement(By.xpath("xpath here")).sendKeys("path of file to upload from computer");
		
		/*Handling Frames
		 * in Selenium
		 */
		driver.findElement(By.name("uname")).sendKeys("speicfy uname");
		driver.findElement(By.name("pass")).sendKeys("speicfy pwd");
		driver.findElement(By.xpath("xpath here")).click();//click submit button
		Thread.sleep(3000); //wait 3 sec
		
		driver.switchTo().frame("frame name here"); //switch to the frame name specified
		
		Thread.sleep(2000); //wait 2 sec
		
		driver.findElement(By.xpath("xpath of link")).click();
		
		
		/*Mouse movement concept
		 * in Selenium
		 */
		driver.get("http://automationpractice.com"); //goto URL
		
		Actions action = new Actions(driver); //pass driver ref to Actions class
		action.moveToElement(driver.findElement(By.linkText("specify text of link"))).build().perform(); //move mouse to the link
		Thread.sleep(3000); //wait for 3 sec 
		driver.findElement(By.linkText("link visible after mouseover")).click();
		
		/*Drag and Drop concept
		 * in Selenium
		 */
		
		driver.switchTo().frame(0); //1st frame (or when only 1 frame is there)
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("xpath of element to drag"))).moveToElement(driver.findElement(By.xpath("xpath of element to drop on"))).release().build()action.perform();
		
		/*Implicit Wait 
		 * in Selenium
		 */
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //wait for page to load for max 40 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//wait is applicable for ALL elements on the page, although main page has loaded

		/*Custom XPath
		 * when XPath on UI is Absolute
		 */
		 driver.findElement(By.xpath("//input[@class='value of class property']")).sendKeys("test"); //htmltag[@class='value of class']"
		 driver.findElement(By.xpath("//input[@name='value of name property']")).sendKeys("test"); //using @name instead of @clas
		 driver.findElement(By.xpath("//input[contains(@class,'valueofclassproperty')]")).sendKeys("test"); //using contains
		 driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("test");//when id changes each time (test_1,test_2,test_3)
		 driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("test");
		 driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("test");
		
		 /*Custom XPath for Links
		  * all links represented by <a> html tag 
		  */
		 driver.findElement(By.xpath("//a[contains(@text,'Text of <a> tag']")).click();
		 
		 /*driver.findElements
		  * to find number of elements on a page
		  */
		 //total count of links on the page
		 List<WebElement> listofLinks = driver.findElements(By.tagName("a"));//all links start with <a> tag
		 
		 //size of listofLinks
		 System.out.println("size of list"+listofLinks.size());
		 
		 //get text of each link
		 for(int i=0;i<listofLinks.size();i++) {
			String linkText = listofLinks.get(i).getText();
			System.out.println(linkText);
		 }
		 
		 /*Back and Forward simulations
		  * on browser
		  */
		 driver.get("http://google.com"); //open 1st URL google.com
		 driver.navigate().to("http://amazon.com"); //navigate to 2nd URL
		 driver.navigate().back();//go back to google.com
		 Thread.sleep(2000); //wait 2 sec
		 driver.navigate().back(); //go to amazon.com again
		 
		 //Refresh page
		 driver.navigate().refresh();
		 
		 /*
		  * Take screenshot
		  */
		 driver.get("http://google.com");
		 
		 //Take screenshot and store in file format
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //copy the screenshot src object to desired location using copyFile method
		 FileUtils.copyFile(src, new File("specify location on computer to create file(/Users/uname/Documents/google.png)"));
		 
		 /*
		  * Explicity Wait
		  */
		//dynamic wait
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		//goto URL
		 driver.get("http://google.com");
		 
		 //explicit wait (for element specified)
		 clickOn(driver, driver.findElement(By.xpath("xpath of element")),20); //calls clickOn method
		 
		 /*
		  * Handling popup Windows 
		  */
		 //goto URL
		 driver.get("http://google.com");
		 
		 driver.findElement(By.xpath("xpath of 1st popup link")).click();
		 
		 Thread.sleep(2000); //wait 2 sec
		 
		 //get window ids of all popups into a Set object
		 Set<String> handler = driver.getWindowHandles();
		 
		 //use Iterator, because in Set object it doesn't have index to use for loop
		 //Iterator ALWAYS starts at the TOP of the Set object
		 Iterator<String> it = handler.iterator();
		 
		//1st value in the Set (parent window)
		 String parentWindowId = it.next(); 
		 System.out.println("Parent windown Id:"+parentWindowId);
		 
		//2nd value in the Set (child window)
		 String childWindowId = it.next();
		 System.out.println("Child windown Id:"+childWindowId);
		 
		 //switch to child window/popup
		 driver.switchTo().window(childWindowId);
		 Thread.sleep(2000); //wait 2 sec
		 System.out.println("child windown popup title"+driver.getTitle());
		 
		//close the child popup only
		 driver.close();
		 
		 //come back to parent window
		 driver.switchTo().window(parentWindowId);
		 System.out.println("Parent windown popup title"+driver.getTitle());
		 
		 /*
		  * Read config.properties file
		  */
			
		 	//create Properties object
		    Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("location of config.properties");
			prop.load(fis);
			
			//read properties file
			System.out.println("browser is: "+prop.getProperty("browser"));
			System.out.println("URL is: "+prop.getProperty("URL"));
		 
		/*
		 * Headless Browser concept Testing	
		 * using HTMLUnitDriver
		 */
			//HTMLUnitDriver not available in Selenium 3.x version
			//so need to download separate JAR files for HTMLUnitDriver
			WebDriver driver = new HtmlUnitDriver();
			//goto URL
			 driver.get("http://google.com");
			 
			//Print title
			 System.out.println("Page title is"+driver.getTitle());
			 
		/*
		 * JavaScript Executor Concepts
		 * 
		 */
			//goto URL
			 driver.get("http://google.com");
			 
			 /*
			 * Highlight a specific element
			 */
			 
			//login button
			 WebElement loginBtn = driver.findElement(By.xpath("xpath of button")); 
			 Flash(loginBtn, driver); //call static method Flash() to perform flashing action on button
			
		
			/*
			 * Create a border around an element
			 */
			 
			 drawBorder(loginBtn,driver); //call method to draw a boarder
			
			 //Take screenshot with highlighted border 
			 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 //copy the screenshot src object to desired location using copyFile method
			 FileUtils.copyFile(src, new File("specify location on computer to create file(/Users/uname/Documents/google.png)"));
			 
			 /*
			  * Generate Alert on UI
			  */
			 generateAlert(driver, "There is an issue with Login button on Login Page"); //call method to generate alert
			 
			 /*
			  * Click on an element using JS
			  */
			 clickElementByJS(loginBtn, driver); //click on Login button
			 
			 /*
			  * Browser refresh using JS
			  */
			 refreshBrowserByJS(driver);
			 
			 /*
			  * Get title using JS
			  */
			 System.out.println("Page title using JS: "+ getTitleByJS(driver));
			 
			 /*
			  * Get inner text of page using JS
			  */
			 System.out.println("Page inner text using JS: "+ getPageInnerTextByJS(driver));
			 
			 /*
			  * Page Scrolling using JS
			  */
			 scrollPageDownByJS(driver);
			 
			 /*
			  * Scroll until element is visible
			  */
			 scrollIntoViewByJS(loginBtn, driver);
			 
		/*
		 * Element Visibility test
		 * isDisplayed() vs isEnabled() vs isSelected()
		 */
			//goto URL
			 driver.get("http://google.com"); 
			 
			//1. isDisplayed()
			 boolean b1 = driver.findElement(By.id("submit button")).isDisplayed();
			 System.out.println(b1); //true if button is displayed
			 
			//2. isEnabled()
			 boolean b2 = driver.findElement(By.id("submit button")).isEnabled();
			 System.out.println(b2); //true if button is enabled
			 
			 //3. isSelected()
			 boolean b3 = driver.findElement(By.id("check box")).isSelected();
			 System.out.println(b3); //true if check box is selected
			 
			//4. de-select checkbox
			 boolean b4 = driver.findElement(By.id("check box")).isSelected();
			 System.out.println(b4); //false since check box is de-selected
		/*
		 * Dynamic WebTable Handling
		 *  
		 */	
			
		  //1. Method 1: Iterating thru each table entry
			 //XPath of table entry to search for (col 2 of table)
			 String beforeXPath = "//table/tbody/tr[";
			 String afterXPath = "]/td[2]/a";
			 
			 for(int i=4; i<7; i++) { //table rows go from tr[4] to tr[7]
			 String tableEntry = driver.findElement(By.xpath(beforeXPath+i+afterXPath)).getText(); //get each table entry
			 System.out.println(tableEntry);
			 
			 //pass the entry in table to search for
			 if(tableEntry.contains("entry in table")) {
				//if entry found, click on check box on col. 1 of table
				 driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/a")).click(); //click on checkbox
			 	}
			 }
			 
			//2. Method 2: Customize XPath
			 	//using preceding-sibling concept
			 	driver.findElement(By.xpath("//a[contains(text(),'entry in table')]/parent::td//preceding-sibling::td//input[@name='contact-id']")).click();
		
		/*
		* Dynamic Google Search
		*  
		*/
			//goto URL
			driver.get("http://google.com");
			
			//Find ID of google search bar and pass a search term
			driver.findElement(By.id("lst-ib")).sendKeys("search term");
			
			//Get all the <li> tags under parent tag <ul>
			//descendant - gets all the child (descendant) elements of li, in this case all child <div> tags
			//The '//' after <ul> represents ALL child <li> elements of the <ul> tag
			List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
			
			System.out.println("total number of suggestions in search box: "+list.size());
			
			//iterate through the list above
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getText()); //show each text in the list
				
				//Search and click on search term entered
				if(list.get(i).getText().contains("search term")) {
					list.get(i).click();
					break; //once keyword is found, break out of the loop
				}
			}
			
		/*
		* Calendar Handling
		*  
		*/
			//If Calendar is within a frame
			driver.switchTo().frame("framename");
			
			//split date passed by test case into DD,MM,YYYY
			String date1 = "18-September-2017";
			String dateArr[] = date1.split("-");
			String day = dateArr[0];
			String month = dateArr[1];
			String year = dateArr[2];
			
			//select month in dropdown
			Select select = new Select(driver.findElement(By.name("slctMonth")));
			select.selectByVisibleText(month);
			
			//select year in dropdown
			Select select1 = new Select(driver.findElement(By.name("slctYear")));
			select1.selectByVisibleText(year);
			
			//select day in dropdown
				//table format - break xpath
				String beforeXPath = "//*[@id='calendar']/table/tbody/tr[2]/td/table/tbody/tr[";
				String afterXPath = "]/td[";
				
				final int totalWeekDays = 7;
				
				//iterate through rows & cols
				//r2-c1, r2-c2, r2-c3...r2-c7
				//r3-c1, r3-c2, r3-c3...r3-c7
				//...
				boolean flag = false; //set flag to check element found
				String dayVal = null; //value of day read from selenium
				for(int rowNum=2; rowNum<=7; rowNum++) {
					for(int colNum=1; colNum<=7; colNum++) {
						
						try {
						 dayVal = driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).getText();
						}catch(NoSuchElementException e) {
							System.out.println("enter correct date value");
							flag=true; //to break outerloop
							break; //break
						}
						System.out.println(dayVal);
						if(dayVal.equals(day)) {
							driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).click();//click the date
							flag=true;
							break;
						}
						//terminate outer loop ONLY when date is selected
						if(flag=true) {
							break;
						}
					}
				}
				

		/*
		* Calendar Handling using JavaScriptExecutor
		*  
		*/
				
				//select date field element
				WebElement date = driver.findElement(By.id("id of calendar field"));
				
				//specify date to change to
				String dateVal = "30-12-2017";
				
				//call date method
				selectDateByJS(date, driver, dateVal);

		/*
		* Bootstrap Dropdown/Checkbox Handling
		*  
		*/	
				//click on bootstrap checkbox button
				driver.findElement(By.xpath("//button[contains(@class,'multiselect'))]")).click();
				
				//get ALL <li> elements under <ul> into an element array
				List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container']//li//a//label"));
				
				//number of labels under <ul>
				list.size();
				
				//iterating through all the  list elements
				for(int i=0; i<list.size();i++) {
					System.out.println(list.get(i).getText());//print each label to console
					if(list.get(i).getText().contains("Angular")) {
						//don't de-select if already selected
						if(list.get(i).isSelected()) {
							break;
						}
						else {
						list.get(i).click();
						break;
						}
					}
				}
				
				//click on ALL checkbox values
				for(int i=0; i<list.size();i++) {
					System.out.println(list.get(i).getText());//print each label to console
						list.get(i).click();
					}
				
		/*
		* Bootstrap Dropdown/Checkbox Handling
		*  
		*/	
			//button click
				driver.findElement(By.id("dropdownButton")).click();
			
			//all elements in list array
				List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdown-menu-button']//a");
				list.size();
				
			//iterating through all the  list elements
				for(int i=0; i<list.size();i++) {
					System.out.println(list.get(i).getText());//print each label to console
					if(list.get(i).getText().equals("Another action")) {
						list.get(i).click();
						break;
						}
				}
					
		/*
		* Automating videos using Sikuli (add mvn dependency for Sikuli in pom.xml)
		* Sikuli uses images instead of elements
		*/
			//1. take screenshots of buttons on the video player (play, pause, mute etc) and add it to your mvn project
				
			//2. object of Screen class (from Sikuli package)
				Screen s = new Screen();	
				
			//3. Pattern search
				//Pause icon
				Pattern pauseImg = new Pattern("YT_Pause.png);"
				s.wait(pauseImg,2000); //wait for 2 sec for image to load 
				s.click(); //click on image (button on UI)
				s.click(); //sometimes, need to click it twice
				
				//Play icon
				Pattern playImg = new Pattern("YT_Play.png);"
				s.wait(playImg,2000); //wait for 2 sec for image to load 
				s.click(); //click on image (button on UI)
				s.click(); //sometimes, need to click it twice
				
				//Settings icon
				Pattern settingsImg = new Pattern("YT_Settings.png);"
				s.wait(settingsImg,2000); //wait for 2 sec for image to load 
				s.click(); //click on image (button on UI)
				s.click(); //sometimes, need to click it twice

		/*
		* Headless browser testing using Chrome in selenium
		*/
			/* MANDATORY:	
			* 1. chrome version >59
			* 2. window-size=1400,800
			*/
			//create object of ChromeOptions class
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("window-size=1400,800"); //default window size is mobile window,so change it here
			  options.addArguments("headless"); //specify headless window testing
			  
			  //pass options object to webdriver obj
			    WebDriver driver = new ChromeDriver(options);
				
				driver.manage().window().maximize(); //maximize browser window
				driver.manage().deleteAllCookies(); //delete all cookies
				
				//dynamic wait
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//goto URL
				driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		/*
		 * Checking for Broken Links or Broken Images using Selenium
		 */
				//goto URL
				driver.get("http://automationpractice.com");
				
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
						System.out.println(linksList.get(i).getAttribute("href"));
						
						//igore hrefs that are null
						//and
						//ignore hrefs that contain 'javascript' word
						if(linksList.get(i).getAttribute("href") != null && ( ! linksList.get(i).getAttribute("href").contains("javascript"))){ 
							activeLinks.add(linksList.get(i)); //only active links are added in the list
						}
					}
					
				//3. get size of activeLinks list:
					System.out.println("# of active links and images: "+activeLinks.size());
					
				//4. check href URL with httpconnection API
					for(int j=0; j<activeLinks.size(); j++) {
						
						//use URL class obj and cast it as HttpURLConnection obj
						//HttpURLConnection gives HTTP features
						HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
						
						//connect with specific URL
						connection.connect(); 
						
						//check response code returned
						//200 --OK
						//400 --not found
						//500 --internal error
						//400 --bad request
						String response = connection.getResponseMessage();
						
						//disconnect connection
						connection.disconnect();
						
						System.out.println(activeLinks.get(j).getAttribute("href")+"---->"+response);
					}
					
					
					
	}
		//create a new class (outside main method)
		 public static void clickOn(WebDriver driver, WebElement locator, int timeout) throws FileNotFoundException {
			 new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
			 locator.click();
			 
		 }
		 
		 //create a new class (outside main method)
		 public static void Flash(WebElement element, WebDriver driver) {
			 JavaScriptExecutor js = ((JavaScriptExecutor) driver);
			 String bgcolor = element.getCssValue("backgroundColor");
			 
			 //highlight element 10 times (flashing)
			 for(int i=0; i<10; i++) { //10: number of times to flash
				 changeColor("rgb(0,200,0)", element, driver); //pass the color to change to, in this case green
				 changeColor(bgcolor, element, driver); //convert back to default color
			 	}
			 
		 }
			
		 //create a new class (outside main method)
		 public static void changeColor(String color, WebElement element, WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 String bgcolor = element.getCssValue("backgroundColor"); //get bgcolor of that element
			 
			 //executeScript - method used to execute JavaScript code
			 jsexec.executeScript("arguments[0].style.backgroundColor= "+color+"'", element);
			 
				 try {
					Thread.sleep(20); 
				 }catch (InterruptedException e) {
			 }
		 }
		 
		 //create a new class (outside main method)
		 public static void drawBorder(WebElement element, WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //draw border
			 jsexec.executeScript("arguments[0].style.border='3px solid red'", element); //set border color in JS
		 }
		
		//create a new class (outside main method)
		 public static void generateAlert(WebDriver driver, String message) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //alert generation
			 jsexec.executeScript("alert('"+message+"')"); //display alert message in JS
		 }
		 
		//create a new class (outside main method)
		 public static void clickElementByJS(WebElement element, WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //click on an element using JS
			 jsexec.executeScript("arguments[0].click()", element); //click on the element specific
		 }
		 
		//create a new class (outside main method)
		 public static void refreshBrowserByJS(WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //refresh browser using JS
			 jsexec.executeScript("history.go(0)"); //0 means first history
		 }
		 
		//create a new class (outside main method)
		 public static String getTitleByJS(WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //get title using JS
			 String title = jsexec.executeScript("return document.title;").toString();
			 return title;
		 }

		//create a new class (outside main method)
		 public static String getPageInnerTextByJS(WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //get inner Text of page using JS
			 String innerText = jsexec.executeScript("return document.documentElement.innerText;").toString();
			 return innerText;
		 }
		 
		//create a new class (outside main method)
		 public static void scrollPageDownByJS(WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //get inner Text of page using JS
			jsexec.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //scroll from 0 to height of scroller
		 }
		 
		//create a new class (outside main method)
		 public static void scrollIntoViewByJS(WebElement element, WebDriver driver) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //scroll until the element is visible
			jsexec.executeScript("arguments[0].scrollIntoBiew(true);", element);
		 }
		 
		//create a new class (outside main method)
		 public static void selectDateByJS(WebElement element,  WebDriver driver, String dateVal) {
			 JavascriptExecutor jsexec = ((JavascriptExecutor) driver); //cast driver into JSExecutor obj
			 //pass date into calendar table
			jsexec.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		 }
		 
		
}
