package week3.day1;

public class ReverseOddWordsinaString {

	public static void main(String[] args) {

		// Defined the String
		String test = "I am a software tester";
		String[] splitWord = test.split(" "); // Split the string into an array of words
		// Iterate through each word in the array
		for (int i = 0; i < splitWord.length; i++) {
			// Check if the word is at an even position (0, 2, 4...)
			if (i % 2 == 0) {
				// Print the even-positioned word followed by a space
				System.out.print(splitWord[i] + " ");
				// If the word is at an odd position (1, 3, 5...)
			} else {
				// Convert the word to a character array
				char[] reverseWord = splitWord[i].toCharArray();

				// Iterate through the character array in reverse order
				for (int j = reverseWord.length - 1; j >= 0; j--) {
					char reverseChar = reverseWord[j]; // Get each character from the reversed array
					System.out.print(reverseChar); // Print the character
				}
				System.out.print(" "); // Print a space after the reversed word
			}
		}
	}

}
