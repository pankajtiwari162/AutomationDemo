/**
 * @author Pankaj
 *
 * */
package com.test.automationpractice.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	private static String  configFilePath      		=   		"./Config/Config.properties";
	private static String  locatorFilePath          	=        "./ObjectRepository/OR.properties";



	/**
	 * method to read config file and get the key value
	 * @return 
	 * @throws FileNotFoundException 
	 * */
	public static String readConfigfile(String keyname) throws FileNotFoundException{
		BufferedReader   reader                =     	 new BufferedReader(new FileReader(configFilePath));
		Properties       config         	   =         new Properties();
		try {
			config.load(reader);
			String value = config.getProperty(keyname);
			reader.close();
			return value;

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(keyname + " not found in Config file");
		}

	}	



	/**
	 * method to read the locator file and get the key value
	 * @throws FileNotFoundException 
	 *  
	 * */

	public static String readPropertyFile(String keyName) throws FileNotFoundException {
		BufferedReader   reader                =     	 new BufferedReader(new FileReader(locatorFilePath));
		Properties       config         	   =         new Properties();
		try {
			config.load(reader);
			String value = config.getProperty(keyName);
			reader.close();
			return value;

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(keyName + " not found in Locators file");
		}        


	} 


	


}
