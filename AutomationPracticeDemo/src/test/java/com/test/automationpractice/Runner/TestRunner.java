package com.test.automationpractice.Runner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="./FeatureFiles/Login.feature", monochrome= true, glue = "com.test.automationpractice.StepDefs",
plugin= {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:",
		"html:target/cucumber-report/", 
		"json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt", 
"junit:target/cucumber-results.xml"},
dryRun= false,
tags="@Smoke"
		)

public class TestRunner {

	@BeforeClass
	public static void setup() {
		ExtentProperties   extenproperties     = ExtentProperties.INSTANCE;
		extenproperties.setReportPath("./Reports/RegressionRun.html");

	}
	@AfterClass
	public static void systemInfo() {
		Reporter.loadXMLConfig(new File("./Config/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", "Win 10");

	}


}
