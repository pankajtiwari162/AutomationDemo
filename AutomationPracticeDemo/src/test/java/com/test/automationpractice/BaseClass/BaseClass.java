/**
 * @author Pankaj
 * */

package com.test.automationpractice.BaseClass;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.automationpractice.Utils.ReadConfigFile;

public class BaseClass {

	static WebDriver  driver   = null;

	/**
	 * @Constructor
	 **/
	public BaseClass() {


	}


	/**
	 * Function to get the browser
	 * @return browser
	 * */

	public String getBrowser() {
		String browser;
		try {
			browser = ReadConfigFile.readConfigfile("BROWSER");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Browser Key not found in Config File");
		}
		return browser;

	}	


	/**
	 * 
	 * Function to get the driver for the framework
	 * */

	public  WebDriver getDriver() throws Exception {
		
		if(driver ==null)	
		{
			String browserName= getBrowser();
			if(ReadConfigFile.readConfigfile("BROWSER").equalsIgnoreCase("Jenkins")) {
				  browserName   = System.getProperty("browserName");
				  System.out.println("Browser value is " + browserName);
			}
			
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", ReadConfigFile.readConfigfile("CHROMEDRIVERPATH"));
				driver       	 =       new ChromeDriver();

			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				System.out.println("in ff method");
				System.setProperty("webdriver.gecko.driver", ReadConfigFile.readConfigfile("FFDRIVERPATH"));
				driver          =        new FirefoxDriver();

			}

			else if(browserName.equalsIgnoreCase("IE")) {
				/**
				 * Code for IE Explorer
				 **/

				System.setProperty("webdriver.ie.driver", ReadConfigFile.readConfigfile("IEDRIVERPATH"));
				driver          =  new InternetExplorerDriver();


			}

			else {
				System.setProperty("webdriver.chrome.driver", ReadConfigFile.readConfigfile("CHROMEDRIVERPATH"));
				driver        	=       new ChromeDriver();
			}
		}
		return driver;

	}
	
	
	/**
	 * initialize the base driver to null
	 * */
	public void setDriver() {
		this.driver=null;
	}
	
}