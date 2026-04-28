package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
	
  @Test(priority=2)
  public void dashboardTest() {
	  objLogin.loginProcess("Admin", "admin123");
	  String dasboardPageTitle = objDashboardPage.getHomePageText();
	  Assert.assertTrue(dasboardPageTitle.contains("Dashboard"));
	  System.out.println("Dashboard");
  }
}
