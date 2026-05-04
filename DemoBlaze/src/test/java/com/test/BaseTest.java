package com.test;

import org.testng.annotations.Test;

import com.page.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	LoginPage objlogin;
	
  @BeforeMethod
  public void beforeClass() {
	  driver.set(new ChromeDriver());
	  driver.get().manage().window().maximize();
	  driver.get().get("https://www.demoblaze.com/");
	  
	  objlogin = new LoginPage(driver.get());
  }

  @AfterMethod
  public void afterClass() {
	  driver.get().close();
  }

}
