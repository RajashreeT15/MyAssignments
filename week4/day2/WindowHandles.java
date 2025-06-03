package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();		
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		//driver.navigate();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//to get the address of the parent window
		String parentWinIrctc = driver.getWindowHandle();
		System.out.println(parentWinIrctc);
		System.out.println(driver.getTitle());
		
		//Click on the Flight 
		driver.findElement(By.xpath("//span[@class='allcircle circleone']")).click();
		Set<String> childWinFlight = driver.getWindowHandles();
		
		//convert set  into list
		List<String> navchildWinFlight = new ArrayList<String>(childWinFlight);
		driver.switchTo().window(navchildWinFlight.get(1));
		String windowHandleChildFlight = driver.getWindowHandle();
		System.out.println(windowHandleChildFlight);
		System.out.println(driver.getTitle());
		
		
	}

}
