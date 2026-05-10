package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.RegistrationPage;

public class LoginActions extends BaseAction{
	
	WebDriverWait wait;
	LoginPage lp;

	public LoginActions(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		lp = new LoginPage(driver);
	}
	
	public void clickMyAcconuntButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.myAccount)).click();
	}
	
	public void clickLoginLink()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.loginLink)).click();
	}
	
	public void setEmail(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.email)).sendKeys(value);
	}
	
	public void setPassword(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.password)).sendKeys(value);
	}
	
	public void clickLoginButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.loginButton)).click();
	}
	
	public void fillDetails(String email, String password)
	{
		setEmail(email);
		setPassword(password);
	}
	
	public void openLoginPage()
	{
		clickMyAcconuntButton();
		clickLoginLink();
	}
	
	public String getLinkText()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(lp.linkText)).getText();
	}
}
