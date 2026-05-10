package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public By myAccount = By.xpath("//i[@class = \"fa fa-user\"]");
	public By loginLink = By.xpath("//a[@href = \"https://tutorialsninja.com/demo/index.php?route=account/login\"]");
	public By email = By.xpath("//input[@name =  \"email\"]");
	public By password = By.xpath("//input[@name =  \"password\"]");
	public By loginButton = By.xpath("//input[@value = \"Login\"]");
	public By linkText = By.xpath("//a[@href = \"https://tutorialsninja.com/demo/index.php?route=account/edit\"]");
}
