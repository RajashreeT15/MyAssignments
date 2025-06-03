package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingCollection {

	public static void main(String[] args) {
		// Declare and initialize the array
		String mNC[] = { "HCL", "Wipro", "Aspire Systems", "CTS" };

		// Add array elements to a list
		List<String> listmNC = new ArrayList<String>();
		for (int i = 0; i < mNC.length; i++) {
			listmNC.add(mNC[i]);

		}
		System.out.println(listmNC);
		// Sort the list in asce order
		Collections.sort(listmNC);

		System.out.println("Asc Sort:" + listmNC);

		// the list in reverse order
		for (int i = listmNC.size() - 1; i >= 0; i--) {
			System.out.print(listmNC.get(i) + ", ");

		}

	}

}
