package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.RegistrationPage;

public class RegistrationActions extends BaseAction{
	
	WebDriverWait wait;
	RegistrationPage rp;

	public RegistrationActions(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		rp = new RegistrationPage(driver);
	}
	
	public void clickMyAcconuntButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.myAccount)).click();
	}
	
	public void clickRegisterLink()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.registerLink)).click();
	}
	
	public void setFirstName(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.firstName)).sendKeys(value);
	}
	
	public void setLastName(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.lastName)).sendKeys(value);
	}
	
	public void setEmail(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.email)).sendKeys(value);
	}
	
	public void setPhoneNumeber(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.phone)).sendKeys(value);
	}
	
	public void setPassword(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.password)).sendKeys(value);
	}
	
	public void setConfirmPassword(String value)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.confirmPassword)).sendKeys(value);
	}
	
	public void checkPrivacyPolicy()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.privacyPolicy)).click();
	}
	
	public void clickContinueButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(rp.continueButton)).click();
	}
	
	public void fillDetails(String firstName, String lastName, String email, String phone, String password, String confirm)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNumeber(phone);
		setPassword(password);
		setConfirmPassword(confirm);
		checkPrivacyPolicy();
	}
	
	public void openRegistrationPage()
	{
		clickMyAcconuntButton();
		clickRegisterLink();
	}
	
	public String getGreetMessage()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(rp.greetMessage)).getText();
	}
}
