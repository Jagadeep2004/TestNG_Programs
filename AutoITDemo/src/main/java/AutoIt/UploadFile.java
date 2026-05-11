package AutoIt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
	
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pdf2doc.com");
		
		WebElement file = driver.findElement(By.xpath("//span[text()='UPLOAD FILES']"));
		file.click();
		
		Runtime.getRuntime().exec("D:\\DemoAutoIT.exe");
	}

}
