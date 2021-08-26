package com.selenium;

public class DynamicXpathUtility {

//Object ..args -> 	behaves like an Object array
	public static String createXPath(String xpathExpression, Object ...args) {
		
		//Xpath format: //input[@id="{0}"] - 0th element/index		
		for(int i=0; i<args.length; i++) {
			//convert args to Character sequence, since replace() works for single characters	
			xpathExpression = xpathExpression.replace("{"+i+"}", (CharSequence) args[i]);
		}
		
		return xpathExpression;
	}
	
	
	
	public static void main(String[] args) {
		
		String xpath1 = createXPath("//input[@id='{0}']","test");
		System.out.println(xpath1);
		
	//passing 2 arguments to xpath expression	
		String xpath2 = createXPath("//input[@id='{0}' and @name='{1}']","email", "username");
		System.out.println(xpath2);
		
	//passing 3 arguments to xpath expression	
		String xpath3 = createXPath("//input[@id='{0}' and @name='{1}' and @type='{2}']","email", "username", "text");
		System.out.println(xpath3);
		
	}
}
