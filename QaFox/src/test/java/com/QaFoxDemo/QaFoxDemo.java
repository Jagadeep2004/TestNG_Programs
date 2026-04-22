package com.QaFoxDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.utilsExcel;

public class QaFoxDemo {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Test(dataProvider = "validData", dataProviderClass = utilsExcel.class)
    public void validLogin(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        driver.get().findElement(By.linkText("My Account")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));

        driver.get().findElement(By.linkText("Login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));

        driver.get().findElement(By.id("input-email")).sendKeys(email);
        driver.get().findElement(By.id("input-password")).sendKeys(password);

        driver.get().findElement(By.xpath("//input[@value='Login']")).click();

        wait.until(ExpectedConditions.titleContains("My Account"));

        Assert.assertTrue(driver.get().getTitle().contains("My Account"));

        System.out.println(email + " Login Successful");
    }
    
    @Test(dataProvider = "invalidData", dataProviderClass = utilsExcel.class)
    public void invalidLogin(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        driver.get().findElement(By.linkText("My Account")).click();
        driver.get().findElement(By.linkText("Login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));

        driver.get().findElement(By.id("input-email")).sendKeys(email);
        driver.get().findElement(By.id("input-password")).sendKeys(password);

        driver.get().findElement(By.xpath("//input[@value='Login']")).click();

        WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Warning')]")));

        Assert.assertTrue(warning.getText().contains("Warning"));

        System.out.println("Login not Successful");
    }
    
    @Test
    @Parameters({"validKeyword"})
    public void validSearchKeyword(String validKeyword) {
    	
    	WebDriverWait wait = new WebDriverWait(driver.get(),Duration.ofSeconds(20));
    	
    	driver.get().findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(validKeyword);
    	driver.get().findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
    	
    	WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"compare-total\"]")));
    	 
    	Assert.assertEquals(check.getText(),"Product Compare (0)");
    	
    	System.out.println("Search is valid"); 	
    }
    
    @Test
    @Parameters({"invalidKeyword"})
    public void invalidSearchKeyword(String invalidKeyword) {
    	 WebDriverWait wait = new WebDriverWait(driver.get(),Duration.ofSeconds(20));
    	 
    	driver.get().findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(invalidKeyword);
     	driver.get().findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
     	
     	WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p[2]")));
     	
     	Assert.assertEquals(check.getText(), "There is no product that matches the search criteria.");
     	
     	System.out.println("Search is invalid");
     	
    }
    

    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforeMethod(String browser, String url) {

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver.set(new ChromeDriver(options));

            driver.get().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            driver.get().get(url);
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.get().quit();
        driver.remove();
    }
}