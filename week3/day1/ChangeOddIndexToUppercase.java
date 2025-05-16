package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {

		String test = "changeme";// declared and initialized with the value "changeme".

		/*
		 * toCharArray() method is called on the test string. This method converts the
		 * string into an array of characters (char).
		 */
		char[] testcharArray = test.toCharArray();
		// System.out.println(testcharArray);

		// for loop that iterates through each character in the testcharArray.
		for (int i = 0; i < testcharArray.length; i++) {
			// System.out.println(testcharArray[i]);

			// Inside the loop, if statement checks if the index i is odd.
			if (i % 2 != 0) {

				// If the index i is odd, this converts the character at that index to
				// uppercase.
				testcharArray[i] = Character.toUpperCase(testcharArray[i]);
				// System.out.println(testcharArray[i]);

			}

		}
		// to create a string from an array of characters.
		String changemeMod = new String(testcharArray);
		System.out.println(changemeMod);
	}

}
