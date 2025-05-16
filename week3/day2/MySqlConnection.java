package week3.day2;

public abstract class MySqlConnection implements DatabseConnection {
	
	public void executeQuery() {
		System.out.println("executeQuery from MySqlConnection abstract class");
	}

}
