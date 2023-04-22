package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class FindTransactionsPage {
	WebDriver driver;

	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	ReadFromExcelFile input = new ReadFromExcelFile();

	public FindTransactionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By findTransactionsLocator = By.linkText(properties.getLocator("findTransactionsLocator"));
	
	By findByAmountLocator = By.id(properties.getLocator("findByAmountLocator"));
	
	By findTransactionButtonForFindByAmountLocator = By.xpath(properties.getLocator("findTransactionButtonForFindByAmountLocator"));
	
	By actualTitleAfterFindTransactionsLocator = By.xpath(properties.getLocator("actualTitleAfterFindTransactionsLocator"));
	
	
	public void findTransactionsByAmount() {
		try {
			driver.findElement(findTransactionsLocator).click();
			
			String amountToBeEntered = input.readTestDataExcel().get("FindTransactionByAmount");
			driver.findElement(findByAmountLocator).sendKeys(amountToBeEntered);
			
			driver.findElement(findTransactionButtonForFindByAmountLocator).click();
			
			String expectedTitleAfterFindTransactions = input.readTestDataExcel().get("ExpectedTitleAfterFindTransactions");
			String actualTitleAfterFindTransactions = driver.findElement(actualTitleAfterFindTransactionsLocator).getText();
			Assert.assertEquals(actualTitleAfterFindTransactions, expectedTitleAfterFindTransactions);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
}
