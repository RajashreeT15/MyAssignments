package week3.day1;

import java.util.Arrays;

public class FindDups {

	public static void main(String[] args) {
		PrintDuplicates pd = new PrintDuplicates();
		int[] num = pd.num;

		// sort the array
		Arrays.sort(num);

		System.out.println("Duplicate values:");
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1]) {
				System.out.print(num[i]+" ");
			}

		}

	}

}
