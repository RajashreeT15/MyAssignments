package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumber {

	public static void main(String[] args) {
		int array[] = { 3, 2, 11, 4, 6, 7 };

		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			// System.out.println(arrayList);
		}
		System.out.println(arrayList);

		Collections.sort(arrayList);

		Integer secondLargest = arrayList.get(arrayList.size() - 2);
		System.out.println(secondLargest);

	}

}
