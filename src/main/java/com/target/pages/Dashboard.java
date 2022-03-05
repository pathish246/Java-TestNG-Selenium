package com.target.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.target.common.BasePage;

public class Dashboard extends BasePage {
	
	WebDriver driver;
	
	@FindBy(id = "search")
	WebElement textbox_search;
	
	@FindBy(xpath = "//button[text()='go']")
	WebElement button_searchGo;
	
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void search(String text)
	{
		setElement(driver, textbox_search, text);
		clickOnElement(driver, button_searchGo);
		
	}

}
