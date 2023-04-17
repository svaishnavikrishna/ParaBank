package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By logoutLocator = By.linkText("Log Out");

	public void logout() {
		driver.findElement(logoutLocator).click();
		driver.close();
	}

}
