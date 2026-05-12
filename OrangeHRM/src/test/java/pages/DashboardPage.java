package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {

        this.driver = driver;
    }

    By dashboardText = By.xpath("//h6[text()='Dashboard']");

    public boolean verifyDashboard() {

        return driver.findElement(dashboardText).isDisplayed();
    }
}