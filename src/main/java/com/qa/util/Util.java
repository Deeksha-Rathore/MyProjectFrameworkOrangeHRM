package com.qa.util;

import java.util.List;

import org.testng.asserts.SoftAssert;

public class Util {
		
		
		public static SoftAssert compareList(List<String> actualList, List<String> expectedList)
		{
			
			SoftAssert softAssert = new SoftAssert();
			for(int i=0; i<expectedList.size();i++)
			{
				try {
				softAssert.assertEquals(actualList.get(i), expectedList.get(i));
				}
				catch(Exception e)
				{
					
				}
			}
			
			return softAssert;
		}
}
