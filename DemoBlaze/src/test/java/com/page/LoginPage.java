package com.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	public WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "login2")
	WebElement loginButton;
	
	@FindBy(id = "loginusername")
	WebElement username;
	
	@FindBy(id = "loginpassword")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement button;
	
	@FindBy(id = "logout2")
	WebElement logout;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void login(String strUsername,String strPassword) {
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		button.click();	
	}
	
	public String getLogoutText() {
		wait.until(ExpectedConditions.visibilityOf(logout));
		return logout.getText();
	}
	
	
	
	
}
