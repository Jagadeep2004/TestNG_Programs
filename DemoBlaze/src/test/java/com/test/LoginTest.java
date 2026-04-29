package com.test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.utilExcel;

@Listeners(com.test.ListenerITestDemo.class)
public class LoginTest extends BaseTest{
	
	Logger logger = LogManager.getLogger(LoginTest.class);

	
	@Test(priority =1,dataProvider = "validData",dataProviderClass = utilExcel.class)
	public void validLoginTest(String username,String password) {

	    objlogin.login(username,password);

	    Assert.assertEquals(objlogin.getLogoutText(), "Log out");
	    logger.info("Valid Login");
	}
	
	@Test(priority = 2,dataProvider = "invalidData",dataProviderClass = utilExcel.class)
	public void invalidLoginTest(String username,String password) {

	    objlogin.login(username,password);
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        
	    Alert alert = driver.switchTo().alert();
	    
	    String val = alert.getText();
	    
	    
	    Assert.assertTrue(
	    	    val.contains("Wrong password.") ||
	    	    val.contains("User does not exist.")
	    	);
	    alert.accept();
	    Assert.fail("Intentional");
	    System.out.println("Invalid Login");
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
