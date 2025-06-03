package marathon_2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException {
		// Tatacliq site is blocked for me so i tried with other website
		// (https://www.sneakerdistrict.com/)

		// Launching Driver
		ChromeDriver driver = new ChromeDriver();

		// Load the Url
		driver.get("https://www.sneakerdistrict.com/");
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Closing Accept cookies popup
		driver.findElement(By.id("cookiescript_close")).click();
		Thread.sleep(5000);
		
		// MouseHover using Action class
		WebElement mouseHover = driver.findElement(By.partialLinkText("SNEAKERS"));
		// instantiate the action class
		Actions sneakers = new Actions(driver);
		sneakers.moveToElement(mouseHover).perform();
		System.out.println("Done");

		driver.findElement(By.partialLinkText("Puma")).click();
		
		// choose men from catagories filter
		driver.findElement(By.xpath("//input[@value='men']")).click();
		Thread.sleep(5000);

		// Select Sorted by
		WebElement latestCollection = driver.findElement(By.id("category_shop_filter_order"));
		Select sellatestCollection = new Select(latestCollection);
		sellatestCollection.selectByVisibleText("Latest collection");
		System.out.println("Selected");
		Thread.sleep(5000);

		List<WebElement> pumaPrice = driver.findElements(By.xpath("//span[@class='thumbnail__special-price']"));
		List<String> list = new ArrayList<String>();
		for (WebElement each : pumaPrice) {
			String text = each.getText();
			// System.out.println(text);
			list.add(text);

		}
		System.out.println(list);

		driver.findElement(By.xpath("(//a[@class='thumbnail__anchor'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class='form__label form__label--full']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]")).click();
		driver.findElement(By.xpath("//a[@class='cartheader__button-cart cartheader__button']")).click();
		Thread.sleep(5000);
		
		//Comparing CartPrice and total price
		String cartPrice1 = driver.findElement(By.xpath("//span[@class='cart-item__special-price']")).getText();
		String repcartPrice1 = cartPrice1.replaceAll("€", "");
		double cartPrice = Double.parseDouble(repcartPrice1);
		System.out.println("Shopping Cart Price:"+ cartPrice);
		Thread.sleep(5000);

		String totalPrice1 = driver.findElement(By.xpath("(//span[@class='cart-totals__value'])[3]")).getText();
		String reptotalPrice1 = totalPrice1.replaceAll("€", "");
		double totalPrice = Double.parseDouble(reptotalPrice1);
		System.out.println("Total Price:"+ totalPrice);
		Thread.sleep(5000);

		if (cartPrice == totalPrice) {
			System.out.println("Price are Equal");

		} else {
			System.out.println("Price are not Equal");

		}
		driver.quit();

	}

}
