package week4.day1;

public class DemoOverriding extends DemoPolyMorpJavaOverLoading{
	
	public void reportStep(String msg, String status, boolean snap) {

		System.out.println("Overriding Message:" + msg);
		System.out.println("Overriding Status:" + status);
		System.out.println("Snap:" + snap);
		
	}
	
	public void takeSnap() {
		
		System.out.println("takeSnap methods");
		
	}
	
	public static void main(String[] args) {
		DemoOverriding demoO = new DemoOverriding();
		demoO.reportStep("Report Created", "ToDo", false);
		demoO.takeSnap();
		
		}
		
}
