package week4.day1;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjioListInter {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		// Launch the URL https://www2.hm.com/
		driver.get("https://www2.hm.com/");
		// maximize
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// search
		driver.findElement(By.xpath("//button[@id='header-search-button']")).click();

		// enter values in search
		driver.findElement(By.xpath("//input[@id='site-search']")).sendKeys("bags", Keys.ENTER);
		Thread.sleep(2000);

		// Fliter Men
		driver.findElement(By.xpath("//span[text()='Homme']")).click();
		Thread.sleep(5000);

		// Print the count of the items found.
		List<WebElement> noOfBags = driver.findElements(By.xpath("//ul[@data-elid='product-grid']/li"));
		int size = noOfBags.size();
		System.out.println("No of Results:" + size);
		Thread.sleep(500);

		// Get the list of brand of the products displayed in the page and print the list.
		List<WebElement> bags = driver.findElements(By.tagName("h3"));
		Set<String> brands = new HashSet<>();
		for (WebElement brand : bags) {
			brands.add(brand.getText());

		}
		System.out.println(brands);

		/*
		 * List<Integer> list = new ArrayList<Integer>(); for (WebElement each : bags) {
		 * String text = each.getText(); list.add(null) //System.out.println(text);
		 * 
		 */

	}

	// ul[@data-elid='product-grid']/following::a

}
