package com.test;

import org.testng.annotations.Test;

import com.page.*;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
	public static WebDriver driver;
	public LoginPage objLogin;
	public DashboardPage objDashboardPage;

  
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  objLogin = new LoginPage(driver);
      objDashboardPage = new DashboardPage(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
