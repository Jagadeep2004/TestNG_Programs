package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("User clicks {string}")
    public void user_clicks(String value) {

        if (value.equalsIgnoreCase("Log in")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        } else if (value.equalsIgnoreCase("Login Button")) {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Log in']")
            )).click();
        }
    }

    @Then("the login tab appears")
    public void the_login_tab_appears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        Assert.assertTrue(usernameField.isDisplayed());
    }

    @When("User enters uername as {string}")
    public void user_enters_uername_as(String username) {
        WebElement userField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        userField.clear();
        userField.sendKeys(username);
    }

    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        WebElement passField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))
        );
        passField.clear();
        passField.sendKeys(password);
    }

    @Then("User should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        WebElement welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        );
        Assert.assertTrue(welcome.getText().contains("Welcome"));
    }

    @Then("the home need to be appeared with the confirmation message {string}")
    public void the_home_need_to_be_appeared_with_the_confirmation_message(String expected) {
        WebElement welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        );
        Assert.assertEquals(welcome.getText(), expected);
    }

    @Then("User should not be logged in to homepage")
    public void user_should_not_be_logged_in() {

        boolean isPresent = driver.findElements(By.id("nameofuser")).size() > 0;

        if (isPresent) {
            String text = driver.findElement(By.id("nameofuser")).getText();
            Assert.assertFalse(text.contains("Welcome"));
        } else {
            Assert.assertTrue(true);
        }
    }

    @Then("the pop with the message {string} must be appear")
    public void popup_message_should_appear(String expectedMessage) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), expectedMessage);
        alert.accept();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}