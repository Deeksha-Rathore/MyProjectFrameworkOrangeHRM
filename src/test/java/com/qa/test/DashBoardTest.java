package com.qa.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.page.DashBoardPage;
import com.qa.page.LogInPage;
import com.qa.util.Util;

public class DashBoardTest extends TestBase {

	LogInPage loginPage;
	DashBoardPage dashboardPage;

	public DashBoardTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LogInPage();
		dashboardPage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
//	@Test(priority = 1)
//	public void verifyDashboardtitlePage() {
//		 String titleOfDashPage=dashboardPage.verifyDashboardtitle();
//		Assert.assertEquals(titleOfDashPage, "OrangeHRM");
//	}
//	@Test(priority = 2)
//	public void verifyDashboardheader() {
//		boolean flag =dashboardPage.validateDashBoardHeader();
//		Assert.assertTrue(flag);
//	}
//	@Test(priority = 3)
//	public void toVerifyTheUserName() {
//	   boolean flag = dashboardPage.toVerifyTheUserName();
//	   Assert.assertTrue(flag);
//	}

	@Test(priority = 1)
	public void verify_Sidebar_Headers() throws InterruptedException {
		// get the actual headers list
		List<String> actualList = dashboardPage.getSideBarHeaders();
		// verify the headers list

		List<String> expectedList = Arrays.asList(new String[] { "Admin", "PIM", "Leave", "Time" });
		SoftAssert softAssert = Util.compareList(actualList, expectedList);

		softAssert.assertAll();

	}

	@AfterMethod
	public void teardDown() {
		driver.quit();
	}
}
