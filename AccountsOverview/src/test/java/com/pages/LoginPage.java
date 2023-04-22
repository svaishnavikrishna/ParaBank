package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.BaseClass;
import com.util.ReadFromExcelFile;
import com.util.ReadFromPropertiesFile;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadFromExcelFile testInput = new ReadFromExcelFile();
	
	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();
	
	String username;
	
	String password;

	By usernameLocator = By.className(properties.getLocator("usernameLocator"));

	By passwordLocator = By.className(properties.getLocator("passwordLocator"));

	By loginButtonLocator = By.xpath(properties.getLocator("loginButtonLocator"));

	By registerLinkLocator = By.linkText(properties.getLocator("registerLinkLocator"));

	By firstNameLocator = By.id(properties.getLocator("firstNameLocator"));

	By lastNameLocator = By.id(properties.getLocator("lastNameLocator"));

	By addressLocator = By.id(properties.getLocator("addressLocator"));

	By cityLocator = By.id(properties.getLocator("cityLocator"));

	By stateLocator = By.id(properties.getLocator("stateLocator"));

	By zipcodeLocator = By.id(properties.getLocator("zipcodeLocator"));

	By phoneLocator = By.id(properties.getLocator("phoneLocator"));

	By ssnLocator = By.id(properties.getLocator("ssnLocator"));

	By registrationUsernameLocator = By.id(properties.getLocator("registrationUsernameLocator"));

	By registrationPasswordLocator = By.id(properties.getLocator("registrationPasswordLocator"));

	By registrationConfirmPasswordLocator = By.id(properties.getLocator("registrationConfirmPasswordLocator"));

	By registrationRegisterLocator = By.xpath(properties.getLocator("registrationRegisterLocator"));
	
	public void registerNewUser() {

		try {
			driver.findElement(registerLinkLocator).click();
			
			String firstName = testInput.readTestDataExcel().get("FirstName");
			driver.findElement(firstNameLocator).sendKeys(firstName);
			
			String lastName = testInput.readTestDataExcel().get("SecondName");
			driver.findElement(lastNameLocator).sendKeys(lastName);
			
			String address = testInput.readTestDataExcel().get("Address");
			driver.findElement(addressLocator).sendKeys(address);
			
			String city = testInput.readTestDataExcel().get("City");
			driver.findElement(cityLocator).sendKeys(city);
			
			String state = testInput.readTestDataExcel().get("State");
			driver.findElement(stateLocator).sendKeys(state);
			
			String zipcode = testInput.readTestDataExcel().get("Zipcode");
			driver.findElement(zipcodeLocator).sendKeys(zipcode);
			
			String phoneNumber = testInput.readTestDataExcel().get("Phone");
			driver.findElement(phoneLocator).sendKeys(phoneNumber);
			
			String ssn = testInput.readTestDataExcel().get("SSN");
			driver.findElement(ssnLocator).sendKeys(ssn);
			
		    String username = testInput.readTestDataExcel().get("Username");
			driver.findElement(registrationUsernameLocator).sendKeys(username);
			
			String password = testInput.readTestDataExcel().get("Password");
			driver.findElement(registrationPasswordLocator).sendKeys(password);
			driver.findElement(registrationConfirmPasswordLocator).sendKeys(password);

			driver.findElement(registrationRegisterLocator).click();
			
			String expectedTitle = "ParaBank | Customer Created";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			

		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());;
		}

	}
	
	public void loginToParabank() {
		try {
			driver.findElement(usernameLocator).sendKeys(username);
			driver.findElement(passwordLocator).sendKeys(password);
			driver.findElement(loginButtonLocator).click();
			String expectedTitle = "ParaBank | Customer Created";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			
		}catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());;
		}
	}

}
