package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public final static int TIMEOUT = 10;

    private HelperClass() { }

    public static void setUpDriver() {
        if (driver.get() == null) {
            WebDriver chrome = new ChromeDriver();
            driver.set(chrome);

            WebDriverWait webWait = new WebDriverWait(chrome, Duration.ofSeconds(TIMEOUT));
            wait.set(webWait);

            chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            chrome.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}