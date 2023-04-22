package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadFromPropertiesFile;

public class AccountsOverviewPage {
	
	WebDriver driver;
	
	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();

	public AccountsOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By accountsOverviewLocator = By.linkText(properties.getLocator("accountsOverviewLocator"));
	
	public void validateAccountsOverviewPage() {
		try {
			driver.findElement(accountsOverviewLocator).click();
			String expectedTitle = "ParaBank | Accounts Overview";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

}
