package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps {

    LoginPage login;

    DashboardPage dashboard;

    ConfigReader config = new ConfigReader();

    @Given("User is on login page")
    public void user_is_on_login_page() {

        login = new LoginPage(BaseClass.driver);
    }

    @When("User enters valid username")
    public void user_enters_valid_username() {

        login.enterUsername(config.getUsername());
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {

        login.enterPassword(config.getPassword());
    }

    @When("User enters invalid username")
    public void user_enters_invalid_username() {

        login.enterUsername(
        config.getInvalidUsername());
    }

    @When("User enters invalid password")
    public void user_enters_invalid_password() {

        login.enterPassword(
        config.getInvalidPassword());
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {

        login.clickLogin();
    }

    @Then("User should navigate to dashboard page")
    public void user_should_navigate_to_dashboard_page() {

        dashboard =
        new DashboardPage(BaseClass.driver);

        Assert.assertTrue(
        dashboard.verifyDashboard());
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {

        Assert.assertTrue(
        login.verifyErrorMessage());
    }
}