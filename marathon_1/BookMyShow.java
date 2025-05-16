package marathon_1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();// Launch Browser
		driver.manage().window().maximize();// Maximize the window
		driver.get("https://www.bookmyshow.com/");//launch Url (I USED BOOKMYSHOW AS I HAVE NOT ACCESS TO PVR).
		
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();//location as "Chennai"
		driver.findElement(By.xpath("//a[text()='Movies']")).click();
		driver.findElement(By.xpath("//div[text()='Maaman']")).click();//selected Movie
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();//Clicked on book tickets
		driver.findElement(By.xpath("(//div[contains(text(), '10:30 PM')])[2]")).click();//Selected the timing for the theater		
		//driver.findElement(By.xpath(""))

	}

}
