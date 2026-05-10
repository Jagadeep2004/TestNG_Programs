package com.stepDefinition;

import org.testng.Assert;

import com.actions.HomePageActions;
import com.actions.LoginPageActions;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {

    LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();

    @Given("User is on HRMLogin page {string}")
    public void user_is_on_hrm_login_page(String url) {
        HelperClass.openPage(url);
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        objLogin.login();
    }

    @Then("User should be able to login successfully and should see Dashboard")
    public void user_should_be_able_to_login_successfully_and_should_see_dashboard() {
        Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
    }

    // ✅ NEW STEP FOR INVALID LOGIN
    @Then("User should not be able to login successfully and should not see Dashboard")
    public void user_should_not_be_able_to_login_successfully() {
        Assert.assertTrue(objLogin.getErrorMessage().contains("Invalid credentials"));
    }
}