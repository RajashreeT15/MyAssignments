package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAction {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//a[contains(text(),'Try different image')]")).click();

		// 5. Search for oneplus
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("OnePlus 12 phone", Keys.ENTER);
		Thread.sleep(5000);
		/*
		 * driver.findElement(By .xpath(
		 * "//div[@id='brandsRefinements']//span[text()='OnePlus']/ancestor::li//input[@type='checkbox']"
		 * )) .click();
		 */
		Thread.sleep(5000);

		// 6. Get the price of the first product
		WebElement proPrice1 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String proPrice = proPrice1.getText();
		System.out.println("oneplus FIRST RESULT Price:" + proPrice);
		Thread.sleep(5000);

		// 7. Print number of customer ratings
		WebElement custoRating1 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String custoRating = custoRating1.getText();
		System.out.println("Number of customer rating:" + custoRating);

		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		System.out.println(driver.getTitle());

		// 8. Click the first text link of the first image
		driver.findElement(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")).click();
		Thread.sleep(5000);

		Set<String> childwindow = driver.getWindowHandles();
		// convert set into list
		List<String> listChildWindow = new ArrayList<String>(childwindow);
		driver.switchTo().window(listChildWindow.get(1));
		String navchildwind = driver.getWindowHandle();
		System.out.println(navchildwind);
		System.out.println("ChildWindow:" + driver.getTitle());
		Thread.sleep(5000);
        
		//Click the 'Add to Cart' button.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		Thread.sleep(5000);
		
		//Get the cart subtotal and verify if it is correct.
		//driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']")).getText();
		WebElement subtotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-price sw-subtotal-amount']")));
        String subtotalText = subtotal.getText();
        String resubtotalText = subtotalText.replaceAll("₹", "");
        String replsubtotalText = resubtotalText.replaceAll("[^0-9]", "");
       //double dosubtotalText = Double.parseDouble(resubtotalText);
        System.out.println("Cart Subtotal: " + replsubtotalText);
		/*cartSubtotal.getText();
		System.out.println("Cart SubTotal:"+ cartSubtotal);
		*/
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ewc-subtotal-amount']")));
        String totalText = total.getText();
        String retotalText = totalText.replaceAll("₹", "");
        String repltotalText = retotalText.replaceAll("[^0-9]", "");
        //String repltotalText = retotalText.replaceAll(",", "");
        //double dototalText = Double.parseDouble(repltotalText);
        System.out.println("Total: " + repltotalText);
      //span[@class='ewc-subtotal-amount']
        
        if (repltotalText.contains(replsubtotalText)) {
        	System.out.println("Price are Same");
			
		} else {
			System.out.println("Price Mismatch");

		}

	}

}
