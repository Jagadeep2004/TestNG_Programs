package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import actions.SearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinitions {

	public SearchActions sa = new SearchActions(Hooks.driver.get());

	@Given("the user enters the valid search key and give first product from the result Add To Cart")
	public void the_user_enters_the_valid_search_key_and_give_first_product_from_the_result_add_to_cart(
			io.cucumber.datatable.DataTable dataTable) {
		List<String> data = dataTable.asList();
		for (String key : data) {
			sa.addToCart(key);
		}
	}

	@When("click cart button")
	public void click_cart_button() {
		sa.goToCart();
	}

	@Then("the cart should display the added cart products")
	public void the_cart_should_display_the_added_cart_products(io.cucumber.datatable.DataTable dataTable) {
		List<String> products = sa.getCartProducts();
		int numberOfProducts = products.size();
		List<String> data = dataTable.asLists().get(0);
		for (String key : data) {
			for (String product : products) {
				
				System.out.println(key+" "+product);
				if (product.equalsIgnoreCase(key)) {
					numberOfProducts--;
					break;
				}
			}
		}
		
		Assert.assertTrue(numberOfProducts == 0);
	}
}
