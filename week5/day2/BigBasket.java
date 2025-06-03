package week5.day2;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

}
