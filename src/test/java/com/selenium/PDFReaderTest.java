package com.selenium;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {

	public static WebDriver driver;
	
	@SuppressWarnings("static-access")
	@Test
	public void readPDFTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinav\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //maximize browser window
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//goto URL
		driver.get("http://www.orimi.com/pdf-test.pdf");		
		
		URL url = new URL(driver.getCurrentUrl());
		
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
		
	//PDDocument - class provdied by Apache PDFBox API 	
		PDDocument document = null;
		
	//load the pdf file	from the fileParse stream
		document.load(fileParse);
		
	//read content of the loaded PDF	
		String pdfContent = new PDFTextStripper().getText(document);
		
		System.out.println("PDF content is: "+pdfContent);
		
	//Assert statements to confirm PDF content
		Assert.assertTrue(pdfContent.contains("text1 to assert"));
		Assert.assertTrue(pdfContent.contains("text2 to assert"));
		Assert.assertTrue(pdfContent.contains("text3 to assert"));
		
	}
	
}


