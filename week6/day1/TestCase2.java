package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase2 extends ProjectSpecificMethod {

	@Test(dataProvider = "LegalEntityNames")
	public void newLegalEntity(String legalEntityName) throws InterruptedException {

		// 2.Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		System.out.println("Clicked menu");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(driver.getTitle());

		// 3.Click View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		System.out.println("View All");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(5000);

		// Action class initiated because the element is not interceptable
		// click Legal Entities from App Launcher
		WebElement scrollDown = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions actscrollDown = new Actions(driver);
		actscrollDown.scrollToElement(scrollDown).perform();
		System.out.println("ScrollDown was sucessful");
		actscrollDown.click(scrollDown).perform();
		System.out.println("clicked Legal Entities");
		Thread.sleep(5000);

		// Click on the Dropdown icon in the legal Entities tab
		driver.findElement(By.xpath("(//a[@title='Legal Entities']/following::lightning-icon)[1]")).click();
		System.out.println("Clicked Dropdown Icon");
		Thread.sleep(5000);

		// Click on New Legal Entity
		WebElement element = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		System.out.println("Clicked + New Legal Entity");
		Thread.sleep(5000);

		// Enter Name as 'Salesforce Automation by *Your Name*'(Parameterized value)
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(legalEntityName);

		// Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		System.out.println("Saved Successfully");
		WebElement confLegalEntityName = driver
				.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		String legalEntityNameConfirmation = confLegalEntityName.getText();
		if (legalEntityNameConfirmation.equals(legalEntityName)) {
			System.out.println("Names are same");

		} else {
			System.out.println("Names are not same");

		}

	}

	@DataProvider(name = "LegalEntityNames")
	public String[][] testData() {
		// declare 2D array
		String[][] data = new String[3][1];
		data[0][0] = "Salesforce Automation by Rajashree";
		data[1][0] = "Salesforce Automation by Raj";
		data[2][0] = "Salesforce Automation by Shree";

		return data;

	}
}
