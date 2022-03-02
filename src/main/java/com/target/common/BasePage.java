package com.target.common;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

public class BasePage {

	WebDriver driver;
	
	public void fluentWait(WebDriver driver,WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		
		wait.withTimeout(Duration.ofSeconds(180))
		.pollingEvery(Duration.ofMillis(200))
		
		.ignoring(NoSuchElementException.class)
		.ignoring(ElementNotVisibleException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementNotInteractableException.class)
		
		.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void highLightElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style', 'border: 5px solid blue;');", element);
	}
	
	public void setElement(WebDriver driver,WebElement element,String text) {
		try {
			fluentWait(driver, element);
			highLightElement(driver, element);
			element.sendKeys(text);
		}catch(NoSuchElementException NSE) {
			Assert.fail("NoSuchElementException occurred while entering text");
		}catch(ElementNotVisibleException ENV) {
			Assert.fail("ElementNotVisibleException occurred while entering text");
		}catch(StaleElementReferenceException SER) {
			Assert.fail("StaleElementReferenceException occurred while entering text");
		}catch(ElementNotInteractableException ENI) {
			Assert.fail("ElementNotInteractableException occurred while entering text");
		}catch(Exception e) {
			Assert.fail("Exception occurred while entering text");
		}
	}
	
	public void clickOnElement(WebDriver driver,WebElement element) {
		try {
			fluentWait(driver, element);
			highLightElement(driver, element);
			element.click();
		}catch(NoSuchElementException NSE) {
			Assert.fail("NoSuchElementException occurred while entering text");
		}catch(ElementNotVisibleException ENV) {
			Assert.fail("ElementNotVisibleException occurred while entering text");
		}catch(StaleElementReferenceException SER) {
			Assert.fail("StaleElementReferenceException occurred while entering text");
		}catch(ElementNotInteractableException ENI) {
			Assert.fail("ElementNotInteractableException occurred while entering text");
		}catch(Exception e) {
			Assert.fail("Exception occurred while entering text");
		}
	}
	
	public boolean isElementPresent(WebDriver driver,WebElement element) {
		try {
			fluentWait(driver, element);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
