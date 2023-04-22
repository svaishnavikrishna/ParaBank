package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class UpdateContactInfoPage {
	WebDriver driver;

	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	ReadFromExcelFile input = new ReadFromExcelFile();

	public UpdateContactInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	By updateContactInfoLocator = By.linkText(properties.getLocator("updateContactInfoLocator"));

	By updateFirstNameLocator = By.id(properties.getLocator("updateFirstNameLocator"));
	By updateLastNameLocator = By.id(properties.getLocator("updateLastNameLocator"));
	By updateAddressLocator = By.id(properties.getLocator("updateAddressLocator"));
	By updateCityLocator = By.id(properties.getLocator("updateCityLocator"));
	By updateStateLocator = By.id(properties.getLocator("updateStateLocator"));
	By updateZipcodeLocator = By.id(properties.getLocator("updateZipcodeLocator"));
	By updatePhoneNumberLocator = By.id(properties.getLocator("updatePhoneNumberLocator"));
	By updateProfileButtonLocator = By.xpath(properties.getLocator("updateProfileButtonLocator"));

	By actualTitleAfterUpdatingProfilelocator = By.xpath(properties.getLocator("actualTitleAfterUpdatingProfileLocator"));
	
	public void updateDetails() {
		try {
			driver.findElement(updateContactInfoLocator).click();
			
			String updateFirstName = input.readTestDataExcel().get("UpdateFirstName");
			WebElement firstName = driver.findElement(updateFirstNameLocator);
			firstName.clear();
			firstName.sendKeys(updateFirstName);
			
			String updateLastName = input.readTestDataExcel().get("UpdateLastName");
			WebElement lastName = driver.findElement(updateLastNameLocator);
			lastName.clear();
			lastName.sendKeys(updateLastName);
			
			String updateAddress = input.readTestDataExcel().get("UpdateAddress");
			WebElement address = driver.findElement(updateAddressLocator);
			address.clear();
			address.sendKeys(updateAddress);
				
			String updateCity = input.readTestDataExcel().get("UpdateCity");
			WebElement city = driver.findElement(updateCityLocator);
			city.clear();
			city.sendKeys(updateCity);
			
			String updateState = input.readTestDataExcel().get("UpdateState");
			WebElement state = driver.findElement(updateStateLocator);
			state.clear();
			state.sendKeys(updateState);
			
			String updateZipcode = input.readTestDataExcel().get("UpdateZipcode");
			WebElement zipcode = driver.findElement(updateZipcodeLocator);
			zipcode.clear();
			zipcode.sendKeys(updateZipcode);
			
			String updatePhoneNumber = input.readTestDataExcel().get("UpdatePhoneNumber");
			WebElement phoneNumber = driver.findElement(updatePhoneNumberLocator);
			phoneNumber.clear();
			phoneNumber.sendKeys(updatePhoneNumber);
			
			Thread.sleep(2000);
				
			driver.findElement(updateProfileButtonLocator).click();
			
			Thread.sleep(2000);
			
			String expectedTitleAfterUpdatingProfile = input.readTestDataExcel().get("ExpectedTitleAfterUpdatingContactInfo");
			String actualTitleAfterUpdatingProfile = driver.findElement(actualTitleAfterUpdatingProfilelocator).getText();
			Assert.assertEquals(actualTitleAfterUpdatingProfile, expectedTitleAfterUpdatingProfile);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

}
