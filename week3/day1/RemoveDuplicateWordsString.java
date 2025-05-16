package week3.day1;

public class RemoveDuplicateWordsString {

	public static void main(String[] args) {

		// Define the text
		String text = "We learn Java basics as part of java sessions in java week";

		// Initialize a variable ‘count’ to keep track of the number of duplicate
		// splitText found
		int duplicateCount = 0;

		// Split the text into an array of splitText using space as the delimiter
		String[] splitText = text.split(" ");

		// iterate each word in the text
		for (int i = 0; i < splitText.length; i++) {
			// Compare it with every other word that comes after it
			for (int j = i + 1; j < splitText.length; j++) {
				// If we find two splitText that are the same, ignoring uppercase or lowercase
				if (splitText[i].equalsIgnoreCase(splitText[j])) {
					// Replace the second word with empty spaces
					splitText[j] = "  "; // Changed to " " to maintain spaces
					duplicateCount++; // Increase the count of duplicate splitText

					// System.out.print(splitText[i]+" ");
				}
			}
		}

		// If we found any duplicate splitText
		if (duplicateCount > 0) {
			System.out.println("The modified words array where duplicates have been replaced with empty strings");
		}

		// Print the modified text
		for (int i = 0; i < splitText.length; i++) {
			System.out.print(splitText[i] + " ");
		}
	}

}
