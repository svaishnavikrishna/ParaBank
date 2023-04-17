package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoginPage;
import com.pages.LogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	/*
	 * public BaseClass(WebDriver driver) { this.driver = driver; }
	 */

	public ReadFromPropertiesFile properties = new ReadFromPropertiesFile();

	public String url = properties.getApplicationUrl();
	public String browser = properties.getBrowserType();

	public void launchBrowser() {
		try {

			if (browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			else if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("google chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public WebDriver launchApplication() {
		try {

			launchBrowser();

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			/*
			 * LoginPage loginPage = new LoginPage(driver); loginPage.registerNewUser();
			 */

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

		return driver;
	}

	/*
	 * public void logOutOfTheApplication(WebDriver driver) { LogoutPage logOut =
	 * new LogoutPage(driver); logOut.logoutOfTheApplication(); }
	 */

}
