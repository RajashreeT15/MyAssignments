package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		// Load the Url
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximize the window
		driver.manage().window().maximize();
		// enter the username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Navigate to Accounts tab
		driver.findElement(By.linkText("Accounts")).click();

		// click on Create Account button
		driver.findElement(By.linkText("Create Account")).click();

		// Enter an account name.
		driver.findElement(By.id("accountName")).sendKeys("Rajashree");
		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		// Enter a Number Of Employees
		driver.findElement(By.id("numberEmployees")).sendKeys("99");

		// Enter a Site Name as “LeafTaps”
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");

		// Click the "Create Account" button
		driver.findElement(By.className("smallSubmit")).click();

		// Title of the page after account creation
		String title = driver.getTitle();
		System.out.println(title);

		// Close the Browser Window
		driver.close();

	}

}
