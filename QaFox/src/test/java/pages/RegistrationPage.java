package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public By myAccount = By.xpath("//i[@class = \"fa fa-user\"]");
	public By registerLink = By.xpath("//a[@href = \"https://tutorialsninja.com/demo/index.php?route=account/register\"]");
	public By firstName = By.xpath("//input[@name =  \"firstname\"]");
	public By lastName = By.xpath("//input[@name =  \"lastname\"]");
	public By email = By.xpath("//input[@name =  \"email\"]");
	public By phone = By.xpath("//input[@name =  \"telephone\"]");
	public By password = By.xpath("//input[@name =  \"password\"]");
	public By confirmPassword = By.xpath("//input[@name =  \"confirm\"]");
	public By continueButton = By.xpath("//input[@value = \"Continue\"]");
	public By privacyPolicy = By.xpath("//input[@name = \"agree\"]");
	public By greetMessage = By.xpath("//h1[text() = \"Your Account Has Been Created!\"]");
}
