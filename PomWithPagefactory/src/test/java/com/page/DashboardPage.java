package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	
	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	public WebElement dashboardPageTitle;
	
	public String getDashboardTitle() {
		return dashboardPageTitle.getText();
	}
	
}
