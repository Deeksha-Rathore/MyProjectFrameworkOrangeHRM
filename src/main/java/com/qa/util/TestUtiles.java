
package com.qa.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class TestUtiles {

	public static long PAGE_LOADED_TIMEOUT = 60;
	public static long IMPLICIT_WAIT_TIMEOUT = 10;
	
	WebDriver driver;
	
	public String getAlertMessage()
	{
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();
		return msg;
	}


}
