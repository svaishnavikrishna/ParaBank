package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.BaseClass;
import com.util.ReadFromExcelFile;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadFromExcelFile testInput = new ReadFromExcelFile();
	
	String username;
	
	String password;

	By usernameLocator = By.className("username");

	By passwordLocator = By.className("password");

	By loginButtonLocator = By.xpath("//input[@value='Log In']");

	By registerLinkLocator = By.linkText("Register");

	By firstNameLocator = By.id("customer.firstName");

	By lastNameLocator = By.id("customer.lastName");

	By addressLocator = By.id("customer.address.street");

	By cityLocator = By.id("customer.address.city");

	By stateLocator = By.id("customer.address.state");

	By zipcodeLocator = By.id("customer.address.zipCode");

	By phoneLocator = By.id("customer.phoneNumber");

	By ssnLocator = By.id("customer.ssn");

	By registrationUsernameLocator = By.id("customer.username");

	By registrationPasswordLocator = By.id("customer.password");

	By registrationConfirmPasswordLocator = By.id("repeatedPassword");

	By registrationRegisterLocator = By.xpath("//input[@value='Register']");
	
	public void registerNewUser() {

		try {
			driver.findElement(registerLinkLocator).click();
			
			String firstName = testInput.readTestDataExcel().get("FirstName");
			System.out.println("First name is "+firstName);
			driver.findElement(firstNameLocator).sendKeys(firstName);
			
			String lastName = testInput.readTestDataExcel().get("SecondName");
			System.out.println("Last name is "+lastName);
			driver.findElement(lastNameLocator).sendKeys(lastName);
			
			String address = testInput.readTestDataExcel().get("Address");
			System.out.println("Address is "+address);
			driver.findElement(addressLocator).sendKeys(address);
			
			String city = testInput.readTestDataExcel().get("City");
			System.out.println("City is "+city);
			driver.findElement(cityLocator).sendKeys(city);
			
			String state = testInput.readTestDataExcel().get("State");
			System.out.println("State is "+state);
			driver.findElement(stateLocator).sendKeys(state);
			
			String zipcode = testInput.readTestDataExcel().get("Zipcode");
			System.out.println("Zipcode is "+zipcode);
			driver.findElement(zipcodeLocator).sendKeys(zipcode);
			
			String phoneNumber = testInput.readTestDataExcel().get("Phone");
			System.out.println("Phone number is "+phoneNumber);
			driver.findElement(phoneLocator).sendKeys(phoneNumber);
			
			String ssn = testInput.readTestDataExcel().get("SSN");
			System.out.println("SSN is "+ssn);
			driver.findElement(ssnLocator).sendKeys(ssn);
			
		    String username = testInput.readTestDataExcel().get("Username");
			System.out.println("Username is "+username);
			driver.findElement(registrationUsernameLocator).sendKeys(username);
			
			String password = testInput.readTestDataExcel().get("Password");
			System.out.println("Password is "+password);
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
