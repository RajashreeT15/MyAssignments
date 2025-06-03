package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement mouseHoverMore = driver.findElement(By.xpath("//span[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHoverMore).perform();
		Thread.sleep(5000);
		System.out.println("done");

		driver.findElement(By.xpath("(//a[contains(text(),'Crypto')])[3]")).click();
		System.out.println("Clicked");

		// Locate the table
		WebElement table = driver.findElement(By.xpath("//table[@class='yf-1570k0a bd']/tbody"));

		// rowcount
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@class='yf-1570k0a bd']/tbody/tr"));
		int size = rowCount.size();
		System.out.println("RowCount:" + size);
		// ColumnCount
		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@class='yf-1570k0a bd']/thead/tr/th"));
		int size2 = columnCount.size();
		System.out.println("ColumnCount:" + size2);

		// Print the cryptocurrency names from table
		List<WebElement> cryptoCurNames = driver
				.findElements(By.xpath("//table[@class='yf-1570k0a bd']/tbody/tr/td[2]"));
		for (WebElement namesiterate : cryptoCurNames) {
			String namesOfCrypto = namesiterate.getText();
			System.out.println("Names of the CryptoCurrency:" + namesOfCrypto);

		}
	}

}
