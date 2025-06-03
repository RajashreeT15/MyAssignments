package week4.day1;

import java.util.ArrayList;
import java.util.List;

public class FindInterSecList {

	public static void main(String[] args) {

		// Declare the first array
		int array1[] = { 3, 2, 11, 4, 6, 7 };
		// Declare the 2nd array
		int array2[] = { 1, 2, 8, 4, 9, 7 };

		// Convert array1 to arraylist
		List<Integer> arrayList1 = new ArrayList<Integer>();
		for (Integer integer1 : array1) {
			arrayList1.add(integer1);
			// System.out.println(arrayList1);

		}
		System.out.println(arrayList1);

		// Convert array2 to arraylist
		List<Integer> arrayList2 = new ArrayList<Integer>();
		for (Integer integer2 : array2) {
			arrayList2.add(integer2);

		}
		System.out.println(arrayList2);

		List<Integer> intersection = new ArrayList<Integer>();

		for (Integer integer3 : arrayList1) {
			if (arrayList2.contains(integer3)) {
				intersection.add(integer3);
				// System.out.println(intersection);

			}
			//System.out.println(intersection);

		}
		System.out.println(intersection);

	}

}
