package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
  @Test(priority=1)
  public void loginTest() {
	  
	  
	  String title = driver.getTitle();

      Assert.assertTrue(title.contains("OrangeHRM"));
      System.out.println("Login");
	  
	  
  }
}
