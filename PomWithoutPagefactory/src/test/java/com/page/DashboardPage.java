package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	
	By dashboardPageTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageText() {
		return driver.findElement(dashboardPageTitle).getText();
	}

}
