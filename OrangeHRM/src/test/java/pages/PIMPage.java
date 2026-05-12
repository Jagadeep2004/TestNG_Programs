package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {

	WebDriver driver;

	public PIMPage(WebDriver driver) {

		this.driver = driver;
	}

	By pimMenu = By.xpath("//span[text()='PIM']");

	By addEmployeeButton = By.xpath("//a[text()='Add Employee']");

	By firstName = By.name("firstName");

	By lastName = By.name("lastName");

	By saveButton = By.xpath("//button[@type='submit']");

	By successMessage = By.xpath("//h6[text()='Personal Details']");

	By employeeSearchBox = By.xpath("(//input[@placeholder='Type for hints...'])[1]");

	By searchButton = By.xpath("//button[@type='submit']");

	By recordFound = By.xpath("//div[@class='oxd-table-card']");

	By requiredMessage = By.xpath("//span[text()='Required']");

	By noRecordMessage = By.xpath("//span[text()='No Records Found']");

	By middleName = By.name("middleName");

	public void clickPIM() {

		driver.findElement(pimMenu).click();
	}

	public void clickAddEmployee() {

		driver.findElement(addEmployeeButton).click();
	}

	public void enterFirstName(String fname) {

		driver.findElement(firstName).sendKeys(fname);
	}

	public void enterMiddleName(String mname) {

		driver.findElement(middleName).sendKeys(mname);
	}

	public void enterLastName(String lname) {

		driver.findElement(lastName).sendKeys(lname);
	}

	public void clickSave() {

		try {

			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(saveButton).click();
	}

	public boolean verifyEmployeeAdded() {

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return driver.getCurrentUrl().contains("viewPersonalDetails");
	}

	public void searchEmployee(String empName) {

		driver.findElement(employeeSearchBox).sendKeys(empName);
	}

	public void clickSearch() {

		driver.findElement(searchButton).click();
	}

	public boolean verifyEmployeeFound() {

		return driver.findElement(recordFound).isDisplayed();
	}

	public boolean verifyRequiredMessage() {

		return driver.findElement(requiredMessage).isDisplayed();
	}

	public boolean verifyNoRecordFound() {

		return driver.findElement(noRecordMessage).isDisplayed();
	}
}