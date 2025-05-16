package week3.day2;

public class Browser {

	String browserName;
	String browserVersion;

	public void openURL() {
		System.out.println("openURL-SuperClass");
	}

	// Method to close the browser
	public void closeBrowser() {
		System.out.println("closebrowser-superclass");
	}

	// Method to navigate back
	public void navigateBack() {
		System.out.println("Navigating back-superclass");
	}

}
