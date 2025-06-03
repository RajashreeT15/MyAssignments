package marathon_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class Salesforce {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// handled cookies popup
		WebElement rejectButton = driver.findElement(By.xpath("//button[contains(text(), 'Do Not Accept')]"));
		rejectButton.click();

		// Click hamburger menu > Products
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//img[@alt='mobile menu open']").click();
		shadow.findElementByXPath("//span[text()='Products']").click();

		WebElement seeAllProPricing = shadow.findElementByXPath("//a[contains(text(),'See all product pricing')]");
		// instantiation of action class
		Actions actseeAllProPricing = new Actions(driver);
		// Scroll down action
		actseeAllProPricing.scrollToElement(seeAllProPricing).perform();
		System.out.println("ScrollDown was sucessful");
		// Click Action
		actseeAllProPricing.click(seeAllProPricing).perform();
		System.out.println("See All Prodcut Pricing link was CLICKED");

		driver.findElement(By.xpath("//a[contains(text(),'Agentforce')]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();

	}

}
