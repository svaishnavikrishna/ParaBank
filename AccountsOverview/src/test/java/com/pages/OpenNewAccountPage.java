package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class OpenNewAccountPage {

	WebDriver driver;
	
	
	ReadFromExcelFile input = new ReadFromExcelFile();
	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();

	public OpenNewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	String typeOfAccount = properties.getLocator("typeOfAccountLocator");

	By openNewAccountLocator = By.linkText(properties.getLocator("openNewAccountLocator"));

	By selectTypeOfAccountLocator = By.id(properties.getLocator("selectTypeOfAccountLocator"));

	By actualTitleAfterOpeningAccountLocator = By.xpath(properties.getLocator("actualTitleAfterOpeningAccountLocator"));

	By openNewAccountButtonLocator = By.xpath(properties.getLocator("openNewAccountButtonLocator"));

	public void openNewAccount() {
		try {
			driver.findElement(openNewAccountLocator).click();
			Select typeOfAccount = new Select(driver.findElement(selectTypeOfAccountLocator));
			typeOfAccount.selectByVisibleText(properties.getLocator("typeOfAccountLocator"));
			driver.findElement(openNewAccountButtonLocator).click();
			Thread.sleep(2000);
			String expectedTitle = input.readTestDataExcel().get("ExpectedTitleAfterOpeningAccount");
			String actualTitle = driver.findElement(actualTitleAfterOpeningAccountLocator).getText();
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}
}
