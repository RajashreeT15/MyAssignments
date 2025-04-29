package week1.day2;

public class LibraryManagement {

	// Main Method to call the methods of Library Class
	public static void main(String[] args) {
		// Creating Object of Library class
		Library library = new Library();
		// Calling Methods of Library class
		// method addBook called
		System.out.println(library.addBook("Book added successfully"));
		// Method issuebook called
		library.issueBook();

	}

}
