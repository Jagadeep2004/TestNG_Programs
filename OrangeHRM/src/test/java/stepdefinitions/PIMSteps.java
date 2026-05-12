package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PIMPage;
import utilities.ConfigReader;

public class PIMSteps {

    LoginPage login;

    PIMPage pim;

    ConfigReader config =
    new ConfigReader();

    @Given("User is logged into OrangeHRM")
    public void user_is_logged_into_orange_hrm() {

        login =
        new LoginPage(BaseClass.driver);

        BaseClass.driver.get(
        config.getURL());

        login.enterUsername(
        config.getUsername());

        login.enterPassword(
        config.getPassword());

        login.clickLogin();

        pim = new PIMPage(
        BaseClass.driver);
    }

    @When("User clicks PIM module")
    public void user_clicks_pim_module() {

        pim.clickPIM();
    }

    @When("User clicks Add Employee")
    public void user_clicks_add_employee() {

        pim.clickAddEmployee();
    }

    @When("User enters firstname {string}")
    public void user_enters_firstname(
    String firstname) {

        pim.enterFirstName(firstname);
    }

    @When("User enters middlename {string}")
    public void user_enters_middlename(
    String middlename) {

        pim.enterMiddleName(middlename);
    }

    @When("User enters lastname {string}")
    public void user_enters_lastname(
    String lastname) {

        pim.enterLastName(lastname);
    }

    @When("User clicks Save button")
    public void user_clicks_save_button() {

        pim.clickSave();
    }

    @Then("Employee should be added successfully")
    public void employee_should_be_added_successfully() {

        Assert.assertTrue(
        pim.verifyEmployeeAdded());
    }

    @When("User enters employee name in search box")
    public void user_enters_employee_name_in_search_box() {

        pim.searchEmployee(
        config.getEmployeeSearchName());
    }

    @When("User clicks Search button")
    public void user_clicks_search_button() {

        pim.clickSearch();
    }

    @Then("Employee details should be displayed")
    public void employee_details_should_be_displayed() {

        Assert.assertTrue(
        pim.verifyEmployeeFound());
    }

    @When("User leaves firstname empty")
    public void user_leaves_firstname_empty() {

    }

    @Then("Required error message should be displayed")
    public void required_error_message_should_be_displayed() {

        Assert.assertTrue(
        pim.verifyRequiredMessage());
    }

    @When("User enters invalid employee name")
    public void user_enters_invalid_employee_name() {

        pim.searchEmployee(
        config.getInvalidEmployeeName());
    }

    @Then("No records found message should be displayed")
    public void no_records_found_message_should_be_displayed() {

        Assert.assertTrue(
        pim.verifyNoRecordFound());
    }
}