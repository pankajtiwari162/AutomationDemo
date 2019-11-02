package com.test.automationpractice.Pages;

import java.io.FileNotFoundException;

import com.test.automationpractice.Utils.Assertions;
import com.test.automationpractice.Utils.FindPageObject;
import com.test.automationpractice.Utils.ReadConfigFile;
import com.test.automationpractice.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;

public class MyAccount {
	WebDriverUtilities      webdriverutilities			=   		 new  	WebDriverUtilities();	
	FindPageObject          findpageobject				=            new    FindPageObject();
	Assertions               assertion                   =            new     Assertions();
	/**
	 *
	 * @constructor
	 **/

	public MyAccount() throws Exception {

	}

	/**
	 * 
	 * Function to perform click on signout
	 * */

	public void click_SignOut() {
		try {
			webdriverutilities.click(findpageobject.getObjects(ReadConfigFile.readPropertyFile("SIGNOUT")), 5);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Click not performed on SIGNOUT");
			throw new RuntimeException("Click not performed on SIGNOUT");
		}
	}

	
	/**
	 * 
	 * Function to validate the my account page
	 * */
	public void validate_myAccount_Page() {
		try {
			assertion.isElementDisplayed(findpageobject.getObjects(ReadConfigFile.readPropertyFile("RETURNHOME")), 5);
			Reporter.addStepLog("My Account page is visible");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("My Account page is not visible");
			throw new RuntimeException("My Account page is not visible");
		}

	}


}
