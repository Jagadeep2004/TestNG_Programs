package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "login2")
	WebElement loginButton;
	
	@FindBy(id = "loginusername")
	WebElement username;
	
	@FindBy(id = "loginpassword")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement button;
	
	@FindBy(xpath = "//*[@id=\"nameofuser\"]")
	WebElement homepageText;
	
	public void login(String strUsername,String strPassword) {
		loginButton.click();
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		button.click();
		
	}
	
	
}
