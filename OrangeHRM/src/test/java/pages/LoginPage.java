package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By username = By.name("username");

    By password = By.name("password");

    By loginButton = By.xpath("//button[@type='submit']");

    By errorMessage =
    By.xpath("//p[text()='Invalid credentials']");

    public void enterUsername(String uname) {

        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public boolean verifyErrorMessage() {

        return driver.findElement(errorMessage)
                     .isDisplayed();
    }
}