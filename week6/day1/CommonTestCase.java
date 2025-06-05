package week6.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonTestCase {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		// Launch Browser
		ChromeDriver driver = new ChromeDriver(options);

		// URL
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Login Username and Password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vidyar@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sales@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(10000);

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

		/*
		 * Set<String> childWindow = driver.getWindowHandles(); //Convert Set into list
		 * List<String> listChildWindow = new ArrayList<String>(childWindow);
		 * driver.switchTo().window(listChildWindow.get(0)); String addressChildwindow =
		 * driver.getWindowHandle(); System.out.println(addressChildwindow);
		 * System.out.println(driver.getTitle());
		 */
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
		System.out.println("Clicked New Legal Entity");
		Thread.sleep(5000);

		// Enter the Company name as 'TestLeaf'> Enter Description as 'Salesforces'.
		// driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLegalEntity");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Salesforces");

		/*
		 * WebElement status =
		 * driver.findElement(By.xpath("//button[@aria-label='Status']")); Actions
		 * actStatus = new Actions(driver); actStatus.scrollToElement(status).perform();
		 * actStatus.click(status).perform();
		 * driver.findElement(By.xpath("//span[text()='Active']")).click();
		 * System.out.println("Clicked");
		 */

		// Locate and scroll to the Status button using JavaScript
		// Select Status as 'Active'
		WebElement status = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", status);

		// Click the status button to open the dropdown
		status.click();
		System.out.println("Clicked 'Status Dropdown' successfully");

		Thread.sleep(1000); // Wait for the dropdown to appear

		// Scroll and click the 'Active' option
		WebElement activeOption = driver.findElement(By.xpath("//span[text()='Active']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activeOption);
		activeOption.click();

		System.out.println("Clicked 'Active' successfully");

		// Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		System.out.println("Saved Successfully");
		WebElement alert = driver.findElement(By.xpath("//span[text()='Legal Entity Name']"));
		assert alert.isDisplayed();
		WebElement alertMsg = driver.findElement(By.xpath("//h2[contains(text(),'We hit a snag')]"));
		String alertMessage = alertMsg.getText();
		System.out.println(alertMessage);
		
		WebElement fieldName = driver.findElement(By.xpath("//a[contains(text(),'Legal Entity Name')]"));
		String reviewFieldName1 = fieldName.getText();
		System.out.println(reviewFieldName1);
		
		driver.close();
		
	}

}
