package actions;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.SearchPage;

public class SearchActions extends BaseAction{

	WebDriverWait wait;
	SearchPage sp;
	public int cartCount = 0;
	
	public SearchActions(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		sp = new SearchPage(driver);
	}
	
	public void setSearchValue(String key)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(sp.search)).sendKeys(key, Keys.ENTER);
	}
	
	public void clearSearch()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(sp.search)).clear();
	}
	
	public void clickCartButton()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(sp.productCartButton))).click().build().perform();
	}
	
	public void goToCart()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(sp.cartButton)).click();
	}
	
	public String getCartTotal()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sp.cartTotal)).getText();
	}
	
	public List<String> getCartProducts() {
		List<WebElement> products =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sp.cartProducts));
		List<String> productNames = new ArrayList<>();
		
		for(WebElement product: products)
		{
			productNames.add(product.getText());
		}
		
		return productNames;
	}
	
	public void addToCart(String key)
	{
		setSearchValue(key);
		clickCartButton();
		clearSearch();
		cartCount++;
		System.out.println(cartCount+" "+getCartTotal().split(" ")[0]);
	}
}
