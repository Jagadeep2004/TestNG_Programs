package actions;

import org.openqa.selenium.WebDriver;

public class BaseAction {
	public WebDriver driver;
	
	public BaseAction(WebDriver driver)
	{
		this.driver = driver;
	}

}
