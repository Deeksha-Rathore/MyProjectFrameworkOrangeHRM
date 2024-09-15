package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LogInPage extends TestBase {

	// page Factory - OR(Object repository)
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div/button")
	WebElement logInButton;

	@FindBy(className = "oxd-text oxd-text--p orangehrm-login-forgot-header")
	WebElement forgotPassword;

	@FindBy(xpath = "//div[@class= 'orangehrm-login-logo']")
	WebElement hrmLogo;
	
	@FindBy(xpath = "//div[@role= 'alert']")
	WebElement invalidCredential;

	// initialize the Object

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Action
	public String ValidateLogInPage() {
		return driver.getTitle();
	}

	public boolean ValidatehrmLogo() {
		return hrmLogo.isDisplayed();
	}

	public DashBoardPage logIn(String un, String pd) {
		username.sendKeys(un);
		password.sendKeys(pd);
		logInButton.click();
		return new DashBoardPage();
	}
	
	public boolean invalidCredencial(String un, String pd ) {
		username.sendKeys(un);
		password.sendKeys(pd);
		logInButton.click();
		return 	invalidCredential.isDisplayed();
	}
}
