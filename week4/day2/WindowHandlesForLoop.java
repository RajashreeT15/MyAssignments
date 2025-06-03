package week4.day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlesForLoop {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		// You might want to use options.addArguments("--incognito") or similar for a
		// fresh session
		// "guest" might open a guest profile, which is fine if that's the intent.
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
		// Thread.sleep(5000); // Avoid Thread.sleep(). Use explicit waits if needed.

		// Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();
		// Thread.sleep(5000);

		// Click on Merge Contacts
		driver.findElement(By.linkText("Merge Contacts")).click();
		// Thread.sleep(5000);

		// to get the address of the parent window
		String mergeContactsWinHandle = driver.getWindowHandle(); // Renamed for clarity
		System.out.println("Parent Window Title: " + driver.getTitle());
		System.out.println("Parent Window Handle: " + mergeContactsWinHandle);

		// --- Handling the first new window (From Contact) ---
		// Click on the widget
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click();

		// Get all window handles after the new window opens
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles to find the new window
		for (String handle : allWindowHandles) {
			if (!handle.equals(mergeContactsWinHandle)) { // If it's not the parent window handle
				driver.switchTo().window(handle);
				break; // Exit the loop once the new window is found and switched to
			}
		}

		// Now you are on the "Find Contacts" window
		System.out.println("Switched to From Contact Window Title: " + driver.getTitle());
		System.out.println("Switched to From Contact Window Handle: " + driver.getWindowHandle());
		driver.manage().window().maximize();
		// Thread.sleep(5000); // Avoid Thread.sleep()

		// Click the first link text to select a contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		// Switch back to the original (Merge Contacts) window
		driver.switchTo().window(mergeContactsWinHandle);
		System.out.println("Switched back to Merge Contacts Window Title: " + driver.getTitle());
		System.out.println("Switched back to Merge Contacts Window Handle: " + driver.getWindowHandle());

		// Thread.sleep(5000); // Avoid Thread.sleep()

		// --- Handling the second new window (To Contact) ---
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();

		// Get all window handles again (now there might be three if previous was still
		// open, or two if it closed)
		// It's safer to re-get handles because windows might close.
		Set<String> newWindowHandlesAfterTo = driver.getWindowHandles();
		String currentParentHandle = driver.getWindowHandle(); // Get the handle of the current window before switching

		// Iterate through all handles to find the new window
		for (String handle : newWindowHandlesAfterTo) {
			if (!handle.equals(currentParentHandle)) { // If it's not the current parent window
				driver.switchTo().window(handle);
				break;
			}
		}

		// Now you are on the second "Find Contacts" window
		System.out.println("Switched to To Contact Window Title: " + driver.getTitle());
		System.out.println("Switched to To Contact Window Handle: " + driver.getWindowHandle());
		driver.manage().window().maximize();
		// Thread.sleep(5000); // Avoid Thread.sleep()

		// Click the first link text to select a contact
		driver.findElement(By.xpath("((//table//tr)[6]//a[@class='linktext'])[1]")).click();

		// Switch back to the original (Merge Contacts) window
		driver.switchTo().window(mergeContactsWinHandle); // Use the original parent handle again
		System.out.println("Switched back to Merge Contacts Window (2nd time) Title: " + driver.getTitle());
		System.out.println("Switched back to Merge Contacts Window (2nd time) Handle: " + driver.getWindowHandle());

		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(5000);

		// transfer the driver control to the alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text: " + alert.getText());
		alert.accept();
		// Thread.sleep(100000); // This is a very long sleep, likely for manual
		// verification.
		// Use explicit waits for elements to appear or disappear.

		// After accepting the alert, the page might reload or navigate.
		// You need to wait for the element or title you expect.
		// The assertEquals("Simple Page", title); line is likely incorrect as
		// the title after merge is usually "View Contact" or "My Contacts".
		// Let's remove the assertion for now unless you confirm the exact title.

		// Example of waiting for a title (instead of sleep):
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.titleContains("View Contact")); // Or whatever
		// the expected title is

		String finalPageTitle = driver.getTitle();
		System.out.println("Final Page Title: " + finalPageTitle);
		// You should assert on the *actual* title after the merge operation completes
		// For leaftaps, it usually navigates to "View Contact"
		// assertEquals("View Contact", finalPageTitle); // Uncomment and adjust as
		// needed

		driver.quit(); // Use quit() to close all windows opened by the driver
	}

	// Helper method to switch to the new window
	// This is a common utility you'd put in a base class or utility class
	/*public static void switchToNewWindow(ChromeDriver driver, String originalWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(originalWindowHandle)) {
				driver.switchTo().window(handle);
				return; // Found and switched, so exit
			}
		}
		*/
		// Optional: throw an exception if no new window is found after a timeout
		// throw new RuntimeException("No new window found!");
	//}

}
