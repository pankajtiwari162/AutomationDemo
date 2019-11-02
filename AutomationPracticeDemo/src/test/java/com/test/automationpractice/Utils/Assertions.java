

package com.test.automationpractice.Utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automationpractice.BaseClass.BaseClass;
import com.vimalselvam.cucumber.listener.Reporter;

public class Assertions {
	WebDriverWait   wait;
	WebDriver       driver;
	BaseClass       baseclass      =       new BaseClass();


	/**
	 * @constructor
	 * @throws Exception 
	 * 
	 **/
	public Assertions() throws Exception {
		this.driver   =   baseclass.getDriver();
	}


	/**
	 * Function to validate of element is visible
	 * **/
	public void isElementDisplayed(WebElement element, int timeout) {
		try {
			wait  = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(element.toString() + " not displayed");
			throw new RuntimeException(element.toString() + " not displayed");
		}
	}


	/**
	 * @return 
	 * function to check weather element is displayed or not
	 * 
	 * */

	public boolean isElementPresent(WebElement element, int timout) {
		boolean flag  = false;
		try {
			wait  =  new WebDriverWait(driver, timout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed())
				flag = true;

		} catch (Exception e) {

		}
		return flag;
	}

	/**
	 * 
	 * */
	public void textEqual(WebElement element, String expectedText) {
		String actualText   = null;
		try {
			actualText     =  element.getText();
			System.out.println("actualtext " + actualText);
			Assert.assertEquals(expectedText, actualText);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(expectedText  + " is not equal to " + actualText);
			throw new RuntimeException(expectedText  + " is not equal to " + actualText);

		}
	}



	/**
	 * 
	 * Funtion to validate the attribute values
	 * */
	public void validateElementAttributeValue(WebElement element, String attributeName, String expectedValue) {
		String actualAttributeValue    =  null;
		try {
			actualAttributeValue  =      element.getAttribute(attributeName);
			Assert.assertEquals(expectedValue, actualAttributeValue);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(expectedValue  + " attribute value is not equal to " + actualAttributeValue);
			throw new RuntimeException(expectedValue  + " is not equal to " + actualAttributeValue);
		}

	}


}
