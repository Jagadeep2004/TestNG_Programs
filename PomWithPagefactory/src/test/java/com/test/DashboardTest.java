package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
	
  @Test(priority=2)
  public void dashboardTest() {
	  objLogin.login("Admin", "admin123");
	  String dasboardPageTitle = objDashboardPage.getDashboardTitle();
	  Assert.assertTrue(dasboardPageTitle.equals("Dashboard"));
	  System.out.println("Dashboard");
  }
}
