package com.test.automationpractice.Utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automationpractice.BaseClass.BaseClass;

public class WebDriverUtilities {
	WebDriver   		driver;
	WebDriverWait       wait;
	BaseClass           baseclass        =    new BaseClass();

	/**
	 * @constuctor
	 *
	 ***/
	public WebDriverUtilities() {
		try {
			this.driver       =      baseclass.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * function to click the element
	 * **/	

	public  void click(WebElement element, int timeout) {
		try {
			wait = new  WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if(element.isDisplayed())
				element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(element.toString() +" is not clickable");
		}
	}	


	/**
	 * Function to enter value 
	 **/
	public void sendKeys(WebElement element,String value ,int timeout)	{
		try {
			wait = new  WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) 
		{
			e.printStackTrace();
			throw new RuntimeException(value + " not entered in " + element.toString());
		}

	}
	
	
	

}
