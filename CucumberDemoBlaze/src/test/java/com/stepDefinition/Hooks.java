package com.stepDefinition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	@Before
	public static void setUp(Scenario scenario) {
		HelperClass.setUpDriver();
		HelperClass.getDriver().navigate().refresh();
		logger.info(scenario.getName());
	}
	
	@After
	public static void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			File screenshotFile = ((TakesScreenshot)HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			File destinationFile = new File("screeenshots/"+ scenario.getName().replaceAll(" ", "_")+".png");
			FileUtils.copyFile(screenshotFile,destinationFile);
			
			byte[] screenshotBytes = ((TakesScreenshot)HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
			logger.info(scenario.getName());
			
		}
		catch(IOException e) {
			logger.error(e.getMessage());
		}
		}
		else {
			logger.info(scenario.getName());
		}
		HelperClass.tearDown();
		}
	
}
