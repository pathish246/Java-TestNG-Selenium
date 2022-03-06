package com.target.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.target.common.Driver;
import com.target.pages.Dashboard;


public class Search extends Driver {

	WebDriver driver;
	
	@BeforeTest
	public void InitiateBrowser() {
		driver = openBrowser(driver,"CHROME");
	}
	
	@Test
	public void search() {
		
		navigateToURL(driver, "PROD");
		
		Dashboard db = new Dashboard(driver);
		db.search("Shoe");
	}
	
	@AfterTest
	public void disposeInstance() {
		driver.quit();
	}
	
}
