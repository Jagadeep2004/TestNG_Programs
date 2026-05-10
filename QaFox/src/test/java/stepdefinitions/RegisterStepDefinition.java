package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import actions.RegistrationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {
	
	RegistrationActions ra = new RegistrationActions(Hooks.driver);
	

	@Given("the user is on register page")
	public void the_user_is_on_register_page() {
		ra.openRegistrationPage();
	}

	@When("the user enters the valid cedentials")
	public void the_user_enters_the_valid_cedentials(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists();
	    
	    String firstName = data.get(0).get(0);
	    String lastName = data.get(0).get(1);
	    String email = data.get(0).get(2);
	    String phone = data.get(0).get(3);
	    String password = data.get(0).get(4);
	    String confirmPassword = data.get(0).get(5);
	    
	    ra.fillDetails(firstName, lastName, email, phone, password, confirmPassword);
	}

	@When("click continue")
	public void click_continue() {
	    ra.clickContinueButton();
	}

	@Then("the greet message should appear as {string};")
	public void the_greet_message_should_appear_as(String string) {
	    Assert.assertEquals(ra.getGreetMessage(), string);
	}

}
