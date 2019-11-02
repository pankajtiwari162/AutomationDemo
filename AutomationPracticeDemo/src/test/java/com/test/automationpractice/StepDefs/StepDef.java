package com.test.automationpractice.StepDefs;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionId;

import com.test.automationpractice.BaseClass.BaseClass;
import com.test.automationpractice.Pages.Authentication;
import com.test.automationpractice.Pages.HomePage;
import com.test.automationpractice.Pages.MyAccount;
import com.test.automationpractice.Utils.Assertions;
import com.test.automationpractice.Utils.FindPageObject;
import com.test.automationpractice.Utils.ReadConfigFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver  	driver ;
	BaseClass  			baseclass         =     new       BaseClass();
	FindPageObject      findPageObject    =     new       FindPageObject();
	HomePage            homepage          =     new       HomePage();
	Authentication      authentication    =     new       Authentication();
	MyAccount           myaccount         =     new       MyAccount();
	Assertions          assertion         =     new       Assertions();




	/**
	 * @throws Exception 
	 * @constructor of the class
	 * */

	public StepDef() throws Exception {
		this.driver      =   baseclass.getDriver();
	}

	@cucumber.api.java.Before
	public void setup() throws Exception {
		/*	this.driver      =   baseclass.getDriver();
		System.out.println("Driver launched");*/
	}

	@Given("^user open the browser$")
	public void user_open_the_browser() throws Throwable {
		driver.get(ReadConfigFile.readConfigfile("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@When("^user clicks on Sign_In link$")
	public void user_clicks_on_Sign_In_link() throws Throwable {
		homepage.click_Signin_Link();	

	}

	@When("^user enter username \"(.*?)\"$")
	public void user_enter_username(String userName) throws Throwable {
		authentication.enter_UserName(userName);
	}

	@When("^user enter password as \"(.*?)\"$")
	public void user_enter_password_as(String password) throws Throwable {
		authentication.enter_Password(password);
	}

	@Then("^user should be logged in successfully$")
	public void user_should_be_logged_in_successfully() throws Throwable {
		myaccount.validate_myAccount_Page();
	}

	@Then("^user logout from the application$")
	public void user_logout_from_the_application() throws Throwable {
		myaccount.click_SignOut();
	}

	@When("^user clicks on sign in$")
	public void user_clicks_on_sign_in() throws Throwable {
		authentication.click_Submit();
	}

	/**
	 * Method to close the browser session 
	 * */

	@After
	public void tearDown(Scenario scenario) throws IOException, InterruptedException, AWTException 
	{   System.out.println("In tearDown..");        
	if(scenario.isFailed()) 
	{
		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); //stick it in the report
	}

	if(driver!=null)

	{
		driver.close();
		baseclass.setDriver();
		
	}


	}

}
