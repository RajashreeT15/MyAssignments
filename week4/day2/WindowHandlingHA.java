package week4.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingHA {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// enter the username and password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		// Click on the CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		Thread.sleep(5000);

		// Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(5000);

		// Click on Merge Contacts
		driver.findElement(By.linkText("Merge Contacts")).click();
		Thread.sleep(5000);

		// to get the address of the parent window
		String mergeContactsWin = driver.getWindowHandle();
		System.out.println(mergeContactsWin);
		System.out.println(driver.getTitle());

		// Click on the widget of the "From Contact"
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click();
		Set<String> idFromWin = driver.getWindowHandles();
		// convert set into list
		List<String> navidFromWin = new ArrayList<String>(idFromWin);
		driver.switchTo().window(navidFromWin.get(1));
		String findContactsWin = driver.getWindowHandle();
		System.out.println(findContactsWin);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// selecting the first resulting contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(navidFromWin.get(0));
		String mainWin = driver.getWindowHandle();
		System.out.println(mainWin);
		System.out.println(driver.getTitle());

		Thread.sleep(5000);

		// Click on the widget of the "To Contact".
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();

		Set<String> idToWin = driver.getWindowHandles();
		// convert set into list
		List<String> navidToWin = new ArrayList<String>(idToWin);
		driver.switchTo().window(navidToWin.get(1));
		String toContactsWin = driver.getWindowHandle();
		System.out.println(toContactsWin);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// selecting the 2nd resulting contact
		driver.findElement(By.xpath("((//table//tr)[6]//a[@class='linktext'])[1]")).click();

		// to get the address of the parent window
		driver.switchTo().window(navidToWin.get(0));
		String backtoMergeWin = driver.getWindowHandle();
		System.out.println(backtoMergeWin);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// transfer the driver control
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		// Thread.sleep(100000);

		driver.getTitle();

		driver.close();

	}

}
