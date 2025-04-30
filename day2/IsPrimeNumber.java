package week1.day2;

public class IsPrimeNumber {
	public static void main(String[] args) {
		// Declared the number 13
		int prime = 13;

		// It helps to track if any number divides 13.If num stays 0, it means no number
		// could divide it, so it's a prime.

		int num = 0;

		// For Loop Iteration

		for (int i = 2; i <= prime / 2; i++) {
			if (prime % i == 0) {
				// when the above condition satisfies the num will set to 1
				num = 1;
				System.out.println(prime + " is not a prime number.");
				break;
			}
		}

		if (num == 0) {
			System.out.println(prime + " is a prime number.");
		}
	}
}
