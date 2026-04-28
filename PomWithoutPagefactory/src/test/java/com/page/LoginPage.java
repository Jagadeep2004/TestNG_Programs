package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
		
		WebDriver driver;

		By username = By.name("username");
		By password = By.name("password");
		By login = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void setUsername(String strUsername) {
			driver.findElement(username).sendKeys(strUsername);
		}
		
		public void setPassword(String strPassword) {
			driver.findElement(password).sendKeys(strPassword);
		}
		
		public void clickLogin() {
			driver.findElement(login).click();;
		}
		
		public String titleText() {
		    return driver.getTitle();
		}
		
		public void loginProcess(String strUsername,String strPassword) {
			setUsername(strUsername);
			setPassword(strPassword);
			clickLogin();
		}
	

}
