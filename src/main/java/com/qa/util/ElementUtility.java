package com.qa.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtility {
	WebDriver driver;
	
	public List<WebElement> getAllElementsLocatedBy(By locator)
	{
		System.out.println("Inside getAllElementsLocatedBy Method");
		 List<WebElement> list =driver.findElements(locator);
		 return list;
	}
	
	public List<String> getAllElementsTexts(By locator)
	{
		System.out.println("Inside getAllElementsTexts Method");
		 List<WebElement> list =this.getAllElementsLocatedBy(locator);
		 
		 List<String> textsList = new ArrayList<String>();
			
		 System.out.print("Texts: ");
			for(WebElement e : list)
			{
				String text = e.getText();
				 System.out.print(text + ",");
				textsList.add(text);
			}
			
			return textsList;
	}


}
