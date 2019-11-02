package com.test.automationpractice.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.automationpractice.BaseClass.BaseClass;
import com.test.automationpractice.Utils.FindPageObject;
import com.test.automationpractice.Utils.ReadConfigFile;
import com.test.automationpractice.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;

public class HomePage {

	WebDriverUtilities      webdriverutilities			=   		 new  	WebDriverUtilities();	
	FindPageObject          findpageobject				=            new    FindPageObject();

	/**
	 * 
	 * @throws Exception 
	 * @Constructor
	 * **/
	public HomePage() throws Exception {


	}

	/**
	 * Function clicks on Sign in link
	 * 
	 **/

	public void click_Signin_Link()  {
		try {
			webdriverutilities.click(findpageobject.getObjects(ReadConfigFile.readPropertyFile("SIGNIN")), 5);
			Reporter.addStepLog("Click perfomed on Sign In link");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Click not performed on SIGNIN");
			throw new RuntimeException("Click not performed on SIGNIN");

		}

	}


	/**
	 * enter value in search box
	 * */

	public void enter_SearchBox(String valuetoEnter) {
		try {
			webdriverutilities.sendKeys(findpageobject.getObjects(ReadConfigFile.readConfigfile("SEARCHBOX")), valuetoEnter, 5);
			Reporter.addStepLog(valuetoEnter +" entered in Search box");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(valuetoEnter +"  not entered in Search box");
			throw new RuntimeException(valuetoEnter +"  not entered in Search box");
		}

	}

}
