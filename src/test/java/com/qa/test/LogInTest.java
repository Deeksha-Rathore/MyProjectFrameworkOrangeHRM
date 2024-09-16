package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.base.TestBase;
import com.qa.page.DashBoardPage;
import com.qa.page.LogInPage;
import com.relevantcodes.extentreports.ExtentReports;

public class LogInTest extends TestBase {

	LogInPage loginPage;
	DashBoardPage homepage;

	public LogInTest() {
		super();
	}

//	@BeforeClass
//	public static void startTest() {
//		try {
////			extentReport = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport/ExtentReportResults.html", true);
////			extentReport.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));
////			extentTest = extentReport.startTest("Cheeku_Automation");
//		} catch (Exception ex) {
//			System.out.println("Exception: " + ex);
//		}
//	}
	@BeforeClass
	public static void startTest() {
		try {
			sparkReporter = new ExtentSparkReporter("ExtentReport/ExtentReport.html");
			extentReport = new com.aventstack.extentreports.ExtentReports();
			extentReport.attachReporter(sparkReporter);
			extentTest = extentReport.createTest("AutomationTest");
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		}
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LogInPage();
	}

	@Test(priority = 1)
	public void validateLogInPagetitle() throws IOException {
		String title = loginPage.ValidateLogInPage();
		Assert.assertEquals(title, "OrangeHRM");
		extentTest.log(Status.PASS, "Title Matched");
	}

	@Test(priority = 2)
	public void validateHrmLogo() {
		boolean flag = loginPage.ValidatehrmLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void login() {
		homepage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void inValidCredencial() {
		boolean flag = loginPage.invalidCredencial("testing", "admin12345");
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public static void endTest() {
//		extentReport.endTest(extentTest); 
//		extentReport.close();
//		extentReport.flush();
		extentReport.flush();

	}

}
