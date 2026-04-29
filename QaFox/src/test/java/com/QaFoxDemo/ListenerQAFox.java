package com.QaFoxDemo;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

//public class ListenerQAFox implements ITestListener {
//
//    public void onTestFailure(ITestResult result) {
//
//        System.out.println("Test Failed : " + result.getName());
//
//        WebDriver driver = QaFoxDemo.getDriver();
//
//        if (driver != null) {
//            screenshot(driver, result.getName());
//        } else {
//            System.out.println("Driver is null. Screenshot skipped.");
//        }
//    }
//
//    public static void screenshot(WebDriver driver, String testName) {
//
//        File src = ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.FILE);
//
//        File dest = new File(
//                "C:\\Users\\jagad\\OneDrive\\Desktop\\Failed Screenshots\\"
//                        + testName + ".png");
//
//        try {
//            FileUtils.copyFile(src, dest);
//            System.out.println("Screenshot Taken");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


public class ListenerQAFox implements ITestListener{
	public void onFailure(ITestResult result) {
		System.out.println("Test Failed :"+result.getName());
		
		WebDriver driver = QaFoxDemo.getDriver();
		if(driver != null) {
			screenshot(driver,result.getName());	
		}
		else {
			System.out.println("The test is passed");
		}
	}
}
