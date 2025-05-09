package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		
		ChromeDriver driver = new ChromeDriver(options);
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
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rajashree_1");
		// Enter a LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Thangaraj");
		// Enter a Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		// Enter a Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("SeleniumAPR Batch");
		
		//Selecting Employee from source dropdown (index)
		WebElement sourceDP = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select1 = new Select(sourceDP);
		select1.selectByIndex(4);
		
		//Select Automobile in the Marketing Campaign (using visibleText)
		WebElement marketingCId = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select select2 = new Select(marketingCId);
		select2.selectByVisibleText("Automobile");
		
		//Select Corporation in Ownership (using value)
		WebElement ownershipEId = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select select3 = new Select(ownershipEId);
		select3.selectByValue("OWN_CCORP");
		
		
		// Click on create Lead button
		driver.findElement(By.name("submitButton")).click();
		// title verification
		String title1 = driver.getTitle();
		System.out.println(title1);

		// Close the browser window
		driver.close();

	}

}
