package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public By search = By.xpath("//input[@name = \"search\"]");
	public By productCartButton = By.xpath("//h2[text() = \"Products meeting the search criteria\"]/following-sibling::div[2]/div/div/div[2]/div[2]/button");
	public By cartButton = By.xpath("//i[@class = \"fa fa-shopping-cart\"]");
	public By cartTotal = By.xpath("//span[@id = \"cart-total\"]");
	public By cartProducts = By.xpath("//div[@id = \"content\"]/form/div/table/tbody/tr/td[2]/a");
}
