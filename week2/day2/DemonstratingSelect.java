package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DemonstratingSelect {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Launch Browser
		ChromeDriver driver = new ChromeDriver(options);

		// Load the Url
		driver.get("https://en-gb.facebook.com/");

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(), 'Allow all cookies')]/following::span[3]")).click();

		// Click on the Create new account button.
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(5000);

		// Enter the Mandatory Fields
		String firstName = "Agaran";
		String surName = "Raj";
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surName);
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input"))
				.sendKeys("58777966545");

		// Handle all three dropdowns in Date of birth
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select selDay = new Select(day);
		selDay.selectByValue("5");

		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select selMonth = new Select(month);
		selMonth.selectByValue("5");

		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select selYear = new Select(year);
		selYear.selectByValue("2023");
		Thread.sleep(5000);

		// Select the radio button in Gender.
		driver.findElement(By.xpath("//label[text()='Male']/input")).click();

	}

}
