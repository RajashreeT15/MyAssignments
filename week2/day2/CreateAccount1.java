package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount1 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		// Launch Browser
		ChromeDriver driver = new ChromeDriver(options);
		
		// Load the Url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// enter the username and password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		// Click on the CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Navigate to Accounts tab
		driver.findElement(By.linkText("Accounts")).click();

		// click on Create Account button
		driver.findElement(By.linkText("Create Account")).click();
		
		Thread.sleep(5000);

		// Enter an account name.
		String accountName = "TestLeaf Automation Class";
		driver.findElement(By.id("accountName")).sendKeys(accountName);
		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		//Select "ComputerSoftware" as the industry.
		WebElement industry = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select selIndustry = new Select(industry);
		selIndustry.selectByValue("IND_SOFTWARE");
		
		//Select "S-Corporation" as ownership using SelectByVisibleText.
		WebElement ownership = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select selOwnership = new Select(ownership);
		selOwnership.selectByVisibleText("S-Corporation");
		
		//Select "Employee" as the source using SelectByValue'
		WebElement source = driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		Select selSource = new Select(source);
		selSource.selectByValue("LEAD_EMPLOYEE");
		
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		WebElement marketingCampaign = driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		Select selMarketingCampaign = new Select(marketingCampaign);
		selMarketingCampaign.selectByIndex(6);
		
		//Select "Texas" as the state/province using SelectByValue.
		WebElement stateProvince = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select selStateProvince = new Select(stateProvince);
		selStateProvince.selectByValue("TX");
		Thread.sleep(5000);
		
		//Click the "Create Account" button.
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(5000);
		
		//Verify that the account name is displayed correctly.
		String actualAccName = driver.findElement(By.xpath("//span[text()='Account Name']/following::span")).getText();
		//System.out.println(actualAccName);
		if (actualAccName.contains(accountName)) {
			System.out.println(actualAccName);
		}
		else {
			System.out.println("Account name is not showing");
		}

	}

}
