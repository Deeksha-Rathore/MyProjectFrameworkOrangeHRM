package com.qa.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.ElementUtility;

public class DashBoardPage extends TestBase {
	ElementUtility elementUtils;
	
	@FindBy(className = "oxd-topbar-header-breadcrumb-module" )
	WebElement dashboardtitle;
	
	@FindBy(xpath = "//div//li[@class='oxd-userdropdown']")
	WebElement userIdentify;
	
	By sideBarHeaders = By.xpath("//div//ul[@class = 'oxd-main-menu']/li[@class='oxd-main-menu-item-wrapper']");
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyDashboardtitle() {
		return driver.getTitle();	
	}
	
	public boolean validateDashBoardHeader() {
		return dashboardtitle.isDisplayed();
	}
	
	public boolean toVerifyTheUserName() {
		return userIdentify.isDisplayed();
	}
	
	public List<String> getSideBarHeaders() throws InterruptedException{
		Thread.sleep(5000);
		
		List<WebElement> list = driver.findElements(sideBarHeaders);
		
		List<String> headerList = new ArrayList<String>();
		
		for(WebElement e : list)
		{
			headerList.add(e.getText());
		}
		
		return headerList;	
	}



}
