package week3.day2;

public class Chrome extends Browser{
	

	// Method specific to Chrome
	public void openIncognito() {
		System.out.println("Chrome is opening in Incognito mode.-chromesubclass");
	}

	// Method specific to Chrome
	public void clearCache() {
		System.out.println("Chrome is clearing cache.-chromesubclass");
	}
	
	public static void main(String[] args) {
		Chrome chr =new Chrome();
		chr.openURL();
		chr.closeBrowser();
		chr.navigateBack();
		chr.openIncognito();
		chr.clearCache();
		
	}
}
