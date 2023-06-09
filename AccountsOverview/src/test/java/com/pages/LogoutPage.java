package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.ReadFromPropertiesFile;

public class LogoutPage {

	WebDriver driver;
	
	ReadFromPropertiesFile properties = new ReadFromPropertiesFile();

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By logoutLocator = By.linkText(properties.getLocator("logoutLocator"));

	public void logout() {
		driver.findElement(logoutLocator).click();
		driver.close();
	}

}
