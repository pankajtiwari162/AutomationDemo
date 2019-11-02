package com.test.automationpractice.Pages;




import java.io.FileNotFoundException;

import com.test.automationpractice.Utils.FindPageObject;
import com.test.automationpractice.Utils.ReadConfigFile;
import com.test.automationpractice.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;


public class Authentication {

	WebDriverUtilities          webdriverutilities            =       new   WebDriverUtilities();
	FindPageObject              findpageobject                =       new   FindPageObject();



	/**
	 * @constructor
	 **/

	public Authentication() throws Exception {

	}



	/**
	 * function to enter username
	 * */
	public void enter_UserName(String userName) {
		try {
			webdriverutilities.sendKeys(findpageobject.getObjects(ReadConfigFile.readPropertyFile("EMAILADDRESS")),userName , 5);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Reporter.addStepLog(userName  +" not entered in UserName input box");
			throw new RuntimeException(userName  +" not entered in UserName input box");
		}
	}


	/**
	 * 
	 * function to enter password
	 * */
	public void enter_Password(String password) {
		try {
			webdriverutilities.sendKeys(findpageobject.getObjects(ReadConfigFile.readPropertyFile("PASSWORD")),password, 5);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Reporter.addStepLog(password  +" not entered in PASSWORD input box");
			throw new RuntimeException(password  +" not entered in PASSWORD input box");
		}

	}

	/**
	 * 
	 * function to click on Forgot Password link
	 **/
	public void click_ForGotPasswordLink() {

	}


	/**
	 * 
	 * function to click on Submit
	 * */
	public void click_Submit() {
		try {
			webdriverutilities.click(findpageobject.getObjects(ReadConfigFile.readPropertyFile("SIGNINBTN")), 2);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Click not performed on Submit");
			throw new RuntimeException("Click not performed on Submit");
		}

	}

}
