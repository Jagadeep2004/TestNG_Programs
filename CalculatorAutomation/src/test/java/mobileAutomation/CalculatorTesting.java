package mobileAutomation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTesting {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("Setting up device capabilities...");
        
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("RZCY82554JT"); // Your Samsung device ID
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity("com.sec.android.app.popupcalculator.Calculator");
        options.setNoReset(true);

        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Appium session created and Calculator opened!");
    }

    @Test
    public void verifyAdditionWorkflow() {
        System.out.println("Executing math workflow: 5 + 5...");

        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
        

        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        
        WebElement resultField = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        String actualResult = resultField.getText().trim().split(" ")[0];
        
        System.out.println("Result retrieved from device screen: " + actualResult);

      
        Assert.assertEquals(actualResult, "10", "Addition assertion failed!");
    }
    
    @Test
    public void verifySubtractionWorkflow() {
        System.out.println("Executing math workflow: 5 - 5...");

        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub")).click();
        
        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
        
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        
        WebElement resultField = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        String actualResult = resultField.getText().trim().split(" ")[0];
        
        System.out.println("Result retrieved from device screen: " + actualResult);

        
        Assert.assertEquals(actualResult, "0", "Assertion failed!");
    }
    
    @Test
    public void verifyMultiplicationWorkflow() {
        System.out.println("Executing math workflow: 5 * 5...");

     
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
       
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")).click();
        
       
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
     
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

      
        WebElement resultField = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        String actualResult = resultField.getText().trim().split(" ")[0];
        
        System.out.println("Result retrieved from device screen: " + actualResult);

    
        Assert.assertEquals(actualResult, "25", "Assertion failed!");
    }
    
    @Test
    public void verifyDivisionWorkflow() {
        System.out.println("Executing math workflow: 5 / 5...");

     
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
    
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div")).click();
        
      
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
        
     
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

    
        WebElement resultField = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        String actualResult = resultField.getText().trim().split(" ")[0];
        
        System.out.println("Result retrieved from device screen: " + actualResult);

   
        Assert.assertEquals(actualResult, "1", "Assertion failed!");
    }
   

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing the Appium test session...");
            driver.quit();
        }
    }
}
