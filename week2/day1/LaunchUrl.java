package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchUrl {

	public static void main(String[] args) {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		// EdgeDriver driver1 = new EdgeDriver();
		// Load the URL
		driver.get("https://www.facebook.com/");
		// Maximize the window
		driver.manage().window().maximize();
		// title of the page
		String title = driver.getTitle();
		System.out.println(title);

		// driver.findElement(By.className("Allow all cookies")).click();
		driver.findElement(By.id("email")).sendKeys("testleaf.2003@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		// Closing the browser
		driver.close();

	}

}
