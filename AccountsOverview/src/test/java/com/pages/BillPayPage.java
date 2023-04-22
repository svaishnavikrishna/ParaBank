package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class BillPayPage {

	WebDriver driver;

	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	ReadFromExcelFile input = new ReadFromExcelFile();

	public BillPayPage(WebDriver driver) {
		this.driver = driver;
	}

	By billPayLocator = By.linkText(properties.getLocator("billPayLocator"));

	By payeeNameLocator = By.xpath(properties.getLocator("payeeNameLocator"));
	By payeeAddressLocator = By.xpath(properties.getLocator("payeeAddressLocator"));
	By payeeCityLocator = By.xpath(properties.getLocator("payeeCityLocator"));
	By payeeStateLocator = By.xpath(properties.getLocator("payeeStateLocator"));
	By payeeZipcodeLocator = By.xpath(properties.getLocator("payeeZipcodeLocator"));
	By payeePhoneNumberLocator = By.xpath(properties.getLocator("payeePhoneNumberLocator"));
	By payeeAccountNumberLocator = By.xpath(properties.getLocator("payeeAccountNumberLocator"));
	By payeeVerifyAccountNumberLocator = By.xpath(properties.getLocator("payeeVerifyAccountNumberLocator"));
	By payeeAmountToBeTransferredLocator = By.xpath(properties.getLocator("payeeAmountToBeTransferredLocator"));
	By sendPaymentButtonLocator = By.xpath(properties.getLocator("sendPaymentButtonLocator"));
	
	By actualTitleAfterPaymentTransferLocator = By.xpath(properties.getLocator("actualTitleAfterPaymentTransferLocator"));

	public void billPaymentService() {
		try {
			driver.findElement(billPayLocator).click();
			
			String payeeName = input.readTestDataExcel().get("PayeeName");
			driver.findElement(payeeNameLocator).sendKeys(payeeName);
			
			String payeeAddress = input.readTestDataExcel().get("PayeeAddress");
			driver.findElement(payeeAddressLocator).sendKeys(payeeAddress);	
			
			String payeeCity = input.readTestDataExcel().get("PayeeCity");
			driver.findElement(payeeCityLocator).sendKeys(payeeCity);
			
			String payeeState = input.readTestDataExcel().get("PayeeState");
			driver.findElement(payeeStateLocator).sendKeys(payeeState);
			
			String payeeZipcode = input.readTestDataExcel().get("PayeeZipcode");
			driver.findElement(payeeZipcodeLocator).sendKeys(payeeZipcode);
			
			String payeePhoneNumber = input.readTestDataExcel().get("PayeePhone");
			driver.findElement(payeePhoneNumberLocator).sendKeys(payeePhoneNumber);
			
			String payeeAccountNumber = input.readTestDataExcel().get("PayeeAccountNumber");
			driver.findElement(payeeAccountNumberLocator).sendKeys(payeeAccountNumber);
			
			String payeeVerifyAccountNumber = input.readTestDataExcel().get("PayeeVerifyAccountNumber");
			driver.findElement(payeeVerifyAccountNumberLocator).sendKeys(payeeVerifyAccountNumber);
			
			String payeeAmountToBeTransferred = input.readTestDataExcel().get("PayeeAmountTransfer");
			driver.findElement(payeeAmountToBeTransferredLocator).sendKeys(payeeAmountToBeTransferred);
			
			driver.findElement(sendPaymentButtonLocator).click();
			String expectedTitleAfterBillPayment = input.readTestDataExcel().get("ExpectedTitleAfterBillPayment");
			String actualTitleAfterBillPayment = driver.findElement(actualTitleAfterPaymentTransferLocator).getText();
			Assert.assertEquals(actualTitleAfterBillPayment, expectedTitleAfterBillPayment);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
}
