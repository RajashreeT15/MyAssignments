package week3.day2;

public class LoginTestData extends TestData {

	/*
	 * Created 2 methods inside LoginTestData - enterUsername() - enterPassword()
	 */

	public void enterUsername() {
		System.out.println("Enter UserName:LoginTestData");
	}

	public void enterPassword() {
		System.out.println("Enter Password:LoginTestData");
	}
	
        //main method for creating objects and calling methods
	public static void main(String[] args) {

		// objects for both classes and calling their methods
		TestData testData = new TestData();
		LoginTestData loginTestData = new LoginTestData();

		// Called TestData Methods (super class)
		System.out.println("SUPER CLASS METHODS:");
		testData.enterCredentials();
		testData.navigateToHomePage();

		// Called both TestData and LoginTestData Methods (super and sub)
		System.out.println("SUPER AND SUB CLASS METHODS:");
		loginTestData.enterCredentials();
		loginTestData.navigateToHomePage();
		loginTestData.enterUsername();
		loginTestData.enterPassword();

	}
}
