package week4.day1;

public class LoginPage extends BasePage {
	
	@Override
	public void performCommonTasks(int Task) {
		System.out.println("LoginPage performCommonTasks"+Task);
	}

	public static void main(String[] args) {
		
		LoginPage loginpage = new LoginPage();
		BasePage basepage = new BasePage();
		
		System.out.println("-------------METHODS CALLED FROM LOGINPAGE------------");
		loginpage.performCommonTasks(3);
		loginpage.clickElement("ClickElement from LoginPage");
		loginpage.enterText("Text from LoginPage");
		loginpage.findElement("findElement from LoginPage");
		
		System.out.println("-------------METHODS CALLED FROM BASEPAGE------------");
		
		basepage.clickElement("ClickElement from BasePage");
		basepage.enterText("Text from BasePage");
		basepage.findElement("findElement from BasePage");
		basepage.performCommonTasks(1);
		
		
		
	}
}
