package com.target.common;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

	public WebDriver openBrowser(WebDriver driver, String browserName) throws MalformedURLException {
		switch (browserName.toUpperCase()) {
		case "CHROME": {
			
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"),new ChromeOptions());
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
