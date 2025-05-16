package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

		// Defined two input strings
		String text1 = "stops";
		String text2 = "potss";

		// Compare the length of the strings, the content of the string

		int length = text1.length();
		int length2 = text2.length();

		// == are given here instead of equals, because the lengths are integer hence ==
		// are using in the if condition
		if (length == length2) {
			System.out.println("The given Strings Length Matchces");// printing for confirmation, where the lengths of
																	// the string char are equal
			// for text1
			char[] charArray1 = text1.toCharArray(); // strings are converted to charArray using toCharArray method
			Arrays.sort(charArray1); // Sorted using Arrays.sort method
			// iterating the characters
			for (int i = 0; i < charArray1.length; i++) {
				// System.out.println(charArray1[i]);
			}

			// for text2
			char[] charArray2 = text2.toCharArray();// strings are converted to charArray using toCharArray method
			Arrays.sort(charArray2);// Sorted using Arrays.sort method
			// iterating the characters
			for (int i = 0; i < charArray2.length; i++) {
				// System.out.println(charArray2[i]);

			}
			// comparing the sorted arrays
			if (Arrays.equals(charArray1, charArray2)) {
				System.out.println("The given strings are Anagram.");

			} else {
				System.out.println("The given strings are not an Anagram.");

			}

		}
		// lengths mismatch print statement. else statement
		else {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");

		}

	}

}
