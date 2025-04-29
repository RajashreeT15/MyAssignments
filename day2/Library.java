package week1.day2;

public class Library {
	// Method AddBook
	public String addBook(String bookTitle) {
		return bookTitle;		
	}

	//Method IssueBook
	public void issueBook() {
		System.out.println("Book issued successfully");
	}
	
	//Main Method to call the methods of Library Class
	public static void main(String[] args) {
		// Creating Object of Library class
		Library lib = new Library();
		// Calling Methods of Library class
		// method addBook called
		System.out.println(lib.addBook("Book added successfully"));
		//Method issuebook called
		lib.issueBook();

	}

}
