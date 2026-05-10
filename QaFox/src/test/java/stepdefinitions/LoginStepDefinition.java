package stepdefinitions;

import org.testng.Assert;

import actions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	LoginActions la = new LoginActions(Hooks.driver);
	
	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
	   la.openLoginPage();
	}

	@When("the user enters the valid email as {string}")
	public void the_user_enters_the_valid_email_as(String string) {
	    la.setEmail(string);
	}
	
	@When("the user enters the valid password as {string}")
	public void the_user_enters_the_valid_password_as(String string) {
	    la.setPassword(string);
	}

	@When("click login")
	public void click_login() {
	   la.clickLoginButton();
	}

	@Then("the link should appear as {string};")
	public void the_link_should_appear_as(String string) {
	    Assert.assertEquals(la.getLinkText(), string);
	}
}
