package com.test;

import java.io.File;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerITestDemo  implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("TestFailed : "+ result.getName());
		
		WebDriver driver = LoginTest.getDriver();
		
		String path = "Failed Screenshots";
		
		if(driver != null) {			
			screenshot(driver,result.getName(),path);	
		}
		else {
			System.out.println("Test is passed");
		}
		
	}
	
	
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("TestPassed : "+ result.getName());
		
		WebDriver driver = LoginTest.getDriver();
		
		String path = "Success Screenshots";
		
		if(driver != null) {
			screenshot(driver,result.getName(),path);
			
		}
		else {
			System.out.println("Test is passed");
		}
	}
	
	public static void screenshot(WebDriver driver, String testName, String folder) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		
		String path = "C:\\Users\\jagad\\OneDrive\\Desktop\\"+folder+"\\";

		File dest = new File(path+ testName + "_" + time + ".png");
		
		try {
		FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
