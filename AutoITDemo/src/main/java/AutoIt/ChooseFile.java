package AutoIt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChooseFile {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/upload-download");

		WebElement upload = driver.findElement(By.id("uploadFile"));

		upload.sendKeys("D:\\15. Event Management System.pdf");

		String message = driver.findElement(By.id("uploadedFilePath")).getText();

		System.out.println("Message : " + message);
	}
}