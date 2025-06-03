package week4.day1;

public class BasePage {

	public void findElement(String Element) {
		System.out.println("BasePage findElement:"+Element);
	}

	public void clickElement(String ClickElement) {
		System.out.println("BasePage clickElement:"+ClickElement);
	}

	public void enterText(String Text) {
		System.out.println("BasePage enterText:"+Text);
	}

	public void performCommonTasks(int Task) {
		System.out.println("BasePage performCommonTasks"+Task);
	}

}
