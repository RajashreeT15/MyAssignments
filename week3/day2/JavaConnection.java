package week3.day2;

//Concrete class JavaConnection implements DatabaseConnection

// Home Assignments both Demonstrating Interface in Java and Demonstrating Abstraction in Java are implemented in JAvaConnection Concrete Class 

public class JavaConnection extends MySqlConnection implements DatabseConnection {

	// implements from DatabseConnection Interface
	public void connect() {
		System.out.println("Connection done from DatabseConnection interface");

	}

	public void disconnect() {
		System.out.println("Disconnection done from DatabseConnection interface");

	}

	public void executeUpdate() {
		System.out.println("update executed from DatabseConnection interface");

	}

	public void edit() {
		System.out.println("Edit from JavaConnection Class");
	}

	public static void main(String[] args) {
		// object creation for class not for interface (creating object for interface is
		// not possible)
		JavaConnection javaCon = new JavaConnection();

		javaCon.connect();//DatabseConnection interface
		javaCon.disconnect();//DatabseConnection interface
		javaCon.executeUpdate();//DatabseConnection interface
		javaCon.edit();//JavaConnection Concrete Class
		javaCon.executeQuery();//MySqlConnection Abstract Class

	}
}
