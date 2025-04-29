package week1.day2;

public class EdgeBrowser {

	// Main Method to call the method from Browser class
	public static void main(String[] args) {
		// Creating object of browser class
		Browser B = new Browser();
		// Calling methods of Browser Class
		System.out.println(B.launchBrowser("Browser launched successfully"));
		B.loadUrl();

	}

}
