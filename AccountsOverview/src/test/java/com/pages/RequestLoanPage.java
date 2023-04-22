package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class RequestLoanPage {
	WebDriver driver;

	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	ReadFromExcelFile input = new ReadFromExcelFile();

	public RequestLoanPage(WebDriver driver) {
		this.driver = driver;
	}

	By requestLoanPageLocator = By.linkText(properties.getLocator("requestLoanPageLocator"));

	By loanAmountLocator = By.id(properties.getLocator("loanAmountLocator"));
	
	By downpaymentAmountLocator = By.id(properties.getLocator("downpaymentAmountLocator"));
			
	By applyNowButtonLocator = By.xpath(properties.getLocator("applyNowButtonLocator"));
	
	By actualTitleAfterApplyingLoanLocator = By.xpath(properties.getLocator("actualTitleAfterApplyingLoanLocator"));

	public void applyForALoan() {
		try {

			driver.findElement(requestLoanPageLocator).click();
			
			String loanAmount = input.readTestDataExcel().get("LoanAmount");
			driver.findElement(loanAmountLocator).sendKeys(loanAmount);
			
			String downPaymentAmount = input.readTestDataExcel().get("DownpaymentAmount");
			driver.findElement(downpaymentAmountLocator).sendKeys(downPaymentAmount);
			
			driver.findElement(applyNowButtonLocator).click();
			
			String expectedTitleAfterApplyingLoan = input.readTestDataExcel().get("ExpectedTitleAfterApplyingLoan");
			String actualTitleAfterApplyingLoan = driver.findElement(actualTitleAfterApplyingLoanLocator).getText();
			Assert.assertEquals(actualTitleAfterApplyingLoan, expectedTitleAfterApplyingLoan);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());

		}
	}
}
