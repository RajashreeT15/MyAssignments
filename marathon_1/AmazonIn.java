package marathon_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonIn {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();// ChromeBrowser Launch
		driver.manage().window().maximize();// Maximize the window
		driver.get("https://www.amazon.in/");// Launch URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// Implicit Wait as mentioned

		// i am getting popup to avoid i have added
		driver.findElement(By.xpath("//a[contains(text(),'Try different image')]")).click();
		// Search using Bags for Boys
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for boys");
		// Click on the Search button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// printing total num of results
		String totalNoResults = driver
				.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']"))
				.getText();
		System.out.println(totalNoResults);
		Thread.sleep(5000);
		// Selecting the 1st brand
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul//li//i)[1]")).click();
		Thread.sleep(5000);
		// Selecting the 2nd brand
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul//li//i)[2]")).click();
		Thread.sleep(5000);

		// Select "NewArrivals" as Sort using SelectByVisibleText.
		WebElement sortNewArrivals = driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
		Select selsortNewArrivals = new Select(sortNewArrivals);
		selsortNewArrivals.selectByVisibleText("Newest Arrivals");
		Thread.sleep(5000);

		// Selecting 1st item
		String firstResultingInfo = driver.findElement(By.xpath("//div[@role='listitem'][1]")).getText();
		System.out.println(firstResultingInfo);
		Thread.sleep(5000);

		// Title of the page
		String titleOfThePage = driver.getTitle();
		System.out.println(titleOfThePage);

		// Close the Browser Window
		driver.close();
	}

}
