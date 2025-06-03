package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonListInterface {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("//a[contains(text(),'Try different
		// image')]")).click();
		// Search using phones
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phones");
		// Click on the Search button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("kkk");

		List<WebElement> phones = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		List<Integer> list = new ArrayList<Integer>();
		for (WebElement each : phones) {
			String text = each.getText();
			String replaceAll = text.replaceAll(",", "");// 9999

			int mob = Integer.parseInt(replaceAll);

			// System.out.println(text);
			list.add(mob);
		}
		Collections.sort(list);
		System.out.println(list);

		// List<WebElement> priceLinks =
		// driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		/*
		 * //to find the no of links List<WebElement> allLinks =
		 * driver.findElements(By.tagName("a")); //find the size int size =
		 * allLinks.size(); System.out.println(size); //retreive a single link
		 * WebElement name = allLinks.get(1); String text = name.getText();
		 * System.out.println(text);
		 * 
		 * List<String> list=new ArrayList<String>(); for (WebElement each : allLinks) {
		 * String text2 = each.getText(); //System.out.println(text2);
		 * 
		 * list.add(text2); }
		 * 
		 * System.out.println(list); }
		 */

	}
}
