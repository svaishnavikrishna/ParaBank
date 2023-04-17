package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.AccountsOverviewPage;
import com.pages.LoginPage;
import com.util.BaseClass;

public class AccountsOverviewValidation extends BaseClass {
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
		
		AccountsOverviewPage accountsOverview = new AccountsOverviewPage(driver);
		accountsOverview.validateAccountsOverviewPage();

	}
	
	@AfterClass
	public void end() {
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}

}
