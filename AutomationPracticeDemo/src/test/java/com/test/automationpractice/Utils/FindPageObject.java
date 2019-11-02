package com.test.automationpractice.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.test.automationpractice.BaseClass.BaseClass;
import com.vimalselvam.cucumber.listener.Reporter;

public class FindPageObject {
	WebDriver    driver;
	BaseClass    baseclass         =         new  BaseClass();

	/**
	 * @throws Exception 
	 * @Construcor
	 * */
	public FindPageObject() throws Exception {
		this.driver                 =        baseclass.getDriver();
	}






	/**
	 * Funtion to find the object on webpage
	 * @param - pass the key name from OR file
	 * **/	

	public WebElement getObjects(String key) {
		WebElement element		       =               null;
		String locatorType		       =               null;
		String locatorValue            =               null;
		try  {
			String[]     locator       =    			key.split("~");
			locatorType         	   =				locator[0];	
			locatorValue               =				locator[1];
			System.out.println("type " + locator[0]);
			System.out.println("value " + locator[1]);


			if(locatorType.equalsIgnoreCase("id")) {
				element  			   =		driver.findElement(By.id(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("name")) {
				element				   =        driver.findElement(By.name(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("xpath")) {
				element                =         driver.findElement(By.xpath(locatorValue));
			}

			else if(locatorType.equalsIgnoreCase("css")) {
				element                =          driver.findElement(By.cssSelector(locatorValue));
			}

			else if(locatorType.equalsIgnoreCase("linktext")) {
				element                =         driver.findElement(By.linkText(locatorValue));
			}
			else if(locatorType.equalsIgnoreCase("partiallinktext")) {
				element                =         driver.findElement(By.partialLinkText(locatorValue));    
			}
			else if(locatorType.equalsIgnoreCase("classname")) {
				element                = 		driver.findElement(By.className(locatorValue));

			}
			else if(locatorType.equalsIgnoreCase("tagname")) {
				element                =          driver.findElement(By.tagName(locatorValue));

			}

			else {

				Reporter.addStepLog("Incorrect locator type or value");
			}

			return element;

		}   catch(Exception  e)
		{    e.printStackTrace();
		throw  new RuntimeException(locatorValue + " not found");
		}
	}



}
