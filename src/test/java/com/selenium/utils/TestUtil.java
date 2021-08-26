package com.selenium.utils;

import java.util.ArrayList;

public class TestUtil {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> excelData = new ArrayList<Object[]>();
		
		reader = new Xls_Reader(System.getProperty("location of excel file in local"));
		
//row and col count in Excel
//TestData: sheet name in excel
		for(int rowNum = 2; rowNum <= reader.getRowCount("TestData"); rowNum++){
			
			String firstname = reader.getCellData("TestData", "firstname", rowNum); //pass sheet name, col name and row number
			String lastname = reader.getCellData("TestData", "lastname", rowNum);
			String address1 = reader.getCellData("TestData", "address1", rowNum);
			String address2 = reader.getCellData("TestData", "address2", rowNum);
			String city = reader.getCellData("TestData", "city", rowNum);
			String state = reader.getCellData("TestData", "state", rowNum);
			String zip = reader.getCellData("TestData", "zip", rowNum);
			String email = reader.getCellData("TestData", "email", rowNum);
			
		//create an Object array to store values from the excel	
		//Advantage of Object array - can store any kind of object in it	
			Object ob[] = {firstname, lastname, address1, address2, city, state, zip, email};
			excelData.add(ob);
			
		}
		
		return excelData;
	}
}
