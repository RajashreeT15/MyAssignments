package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElement {

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 10, 6, 8 };

		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);

		}
		System.out.println(arrayList);
		Collections.sort(arrayList);
		System.out.println("Sorted List:" + arrayList);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			Integer presentNum = arrayList.get(i);
			Integer missingNum = arrayList.get(i + 1);

			if (missingNum != presentNum + 1) {
				System.out.println("Missing number:" + (presentNum + 1));
			}

		}

	}

}
