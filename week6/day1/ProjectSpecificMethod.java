package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	public RemoteWebDriver driver;

	@Parameters({ "browser", "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String browser, String url, String userName, String pwd) throws InterruptedException {
		// Launch Browser
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("guest");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		// URL
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Login Username and Password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(10000);
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
		System.out.println("Browsers closed sucessfully");
	}

}
