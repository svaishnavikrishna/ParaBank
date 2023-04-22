package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.TransferFundsPage;
import com.util.BaseClass;

public class TransferFundValidation extends BaseClass{
	
	WebDriver driver;

	@BeforeClass
	public void start() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}

	@Test
	public void registerNewUser() {
		LoginPage login = new LoginPage(driver);
		login.registerNewUser();
		
		TransferFundsPage transferFunds = new TransferFundsPage(driver);
		transferFunds.transferFunds();

	}
	
	@AfterClass
	public void end() {
		LogoutPage logout = new LogoutPage(driver);
		logout.logout();
	}

}
