package com.selenium;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeTest {

	public static WebDriver driver;
	
	@Test
	public void barCodeTest() throws IOException, NotFoundException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();


		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//goto URL
		driver.get("http://barcode.tec-it.com/en");
		
		
		//Read Barcode image using tagName attribute
		 String barCodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		 System.out.println("barcode URL"+barCodeURL);
		
		 URL url = new URL(barCodeURL);
		 
		 BufferedImage bufferedImage = ImageIO.read(url);
		 
		// LuminanceSource - Interface instance provided ZXing API
		//BufferedImageLuminanceSource - Class provided by ZXing API (implements LuminanceSource interface)
		 LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		 BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		 
		//Result - ZXing API class which returns the result to get the corresponding barcode text (URL)
		 Result result = new MultiFormatReader().decode(binaryBitmap);
		 System.out.println("barcode link/text is: "+result.getText());
		 
		 driver.quit();
		 
	}
	
}
