package com.target.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public WebDriver openBrowser(WebDriver driver, String browserName) {
		switch (browserName.toUpperCase()) {
		case "CHROME": {
			System.setProperty("webdriver.chrome.driver", "/Users/boney/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		case "SAFARI": {

			break;
		}
		case "FIREFOX": {

			break;
		}
		case "OPERA": {

			break;
		}
		case "IE": {

			break;
		}
		default:
			throw new IllegalArgumentException("Please pass valid browser name - " + browserName);
		}
		return driver;
	}

	public void navigateToURL(WebDriver driver,String environment) {
		switch (environment.toUpperCase()) {
		case "TEST": {

			break;
		}
		case "BETA": {

			break;
		}
		case "STAGING": {

			break;
		}
		case "PROD": {
			driver.get("https://www.target.com/");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + environment.toUpperCase());
		}
	}

}
