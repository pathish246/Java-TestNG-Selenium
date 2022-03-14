package com.target.tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.target.common.Driver;
import com.target.dataprovider.SearchData;
import com.target.pages.Dashboard;

public class Search extends Driver {

	public Search() {
		
	}
	
	WebDriver driver;
	
	@BeforeTest
	public void InitiateBrowser() throws MalformedURLException {
		driver = openBrowser(driver,"CHROME");
	}

	@Test(dataProvider="readExcel",dataProviderClass =SearchData.class)
	public void search(HashMap<String, String> map) {
		
	navigateToURL(driver, "PROD");
		
		Dashboard db = new Dashboard(driver);
		db.search(map.get("Search"));
	}
	
	@AfterTest
	public void disposeInstance() {
		driver.quit();
	}
}
