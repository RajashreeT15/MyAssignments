package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

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

		// Navigate to Leads tab
		driver.findElement(By.linkText("Leads")).click();

		// click on Create Leads button
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter a FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rajashree");
		// Enter a LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Thangaraj");
		// Enter a Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IBS Software");
		// Enter a Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("SeleniumAPR Batch");

		// Click on create Lead button
		driver.findElement(By.name("submitButton")).click();
		// title verification
		String title1 = driver.getTitle();
		System.out.println(title1);

		// Close the browser window
		driver.close();

	}

}
