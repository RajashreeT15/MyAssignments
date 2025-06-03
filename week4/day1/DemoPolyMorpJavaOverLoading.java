package week4.day1;

//Create a Java class
public class DemoPolyMorpJavaOverLoading {
	
	
    
	public void reportStep(String msg, String status) {
		System.out.println("1st Message:" + msg);
		System.out.println("1st Status:" + status);

	}

	public void reportStep(String msg, String status, boolean snap) {

		System.out.println("2nd Message:" + msg);
		System.out.println("2nd Status:" + status);
		System.out.println("Snap:" + snap);

	}

	public static void main(String[] args) {
		DemoPolyMorpJavaOverLoading dpmOL = new DemoPolyMorpJavaOverLoading();
		dpmOL.reportStep("Report Loading successful", "Inprogress");
		dpmOL.reportStep("Report Loading successful", "Completed", true);

	}
}
