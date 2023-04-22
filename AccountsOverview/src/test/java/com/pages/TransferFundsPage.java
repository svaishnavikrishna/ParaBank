package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class TransferFundsPage {
	WebDriver driver;

	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	ReadFromExcelFile input = new ReadFromExcelFile();

	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By transferFundsLocator = By.linkText(properties.getLocator("transferFundsLocator"));

	By amountLocator = By.id(properties.getLocator("amountLocator"));
	
	By transferButtonLocator = By.xpath(properties.getLocator("transferButtonLocator"));
	
	By actualTitleAfterTransferringFundsLocator = By.xpath(properties.getLocator("actualTitleAfterTransferringFundsLocator"));
	
	
	public void transferFunds() {
		try {
			driver.findElement(transferFundsLocator).click();
			String amountToBeEntered = input.readTestDataExcel().get("AmountToBeTransferred");
			driver.findElement(amountLocator).sendKeys(amountToBeEntered);
			driver.findElement(transferButtonLocator).click(); 
			Thread.sleep(2000);
			String expectedTitle = input.readTestDataExcel().get("ExpectedTitleAfterFundTransfer");
			String actualTitle = driver.findElement(actualTitleAfterTransferringFundsLocator).getText();
			
			Assert.assertEquals(actualTitle, expectedTitle);
			
		}catch(Exception e) {
			System.out.println("Excpetion is "+e.getMessage());
		}
	}
}
