
public class CurtisSort {

	public String[] sort(String[] strings) {
		//boolean switched = true;

		//String first = strings[0];
		//String second = strings[1];
		//int count = 0;
		//while (switched == true) {
		//	count = 0;
		//	switched = false;
		//	while (count < strings.length-1) {
		//		first = strings[count];
		//		second = strings[count+1];
		//		if (first.compareTo(second) > 0) {
		//			strings[count] = second;
		//			strings[count+1] = first;
		//			switched = true;
		//		}
		//		count++;
		//	}
		//}

		boolean change = true;
		int count = 1;
		int countThrough = 1; 

		while (change == true) {
			change = false;
			String temp = strings[0];
			int tempCount = 0;
			while(count < strings.length) {
				if (temp.compareTo(strings[count]) > 0) {
					temp = strings[count];
					tempCount = count;
					change = true;
				}
				count ++;
			}

			System.arraycopy(strings, 0, strings, 1,tempCount);
			strings[0] = temp;
			countThrough++;
			count = countThrough;
		}
		return strings;
	}

	public static void main(String[] args) {

		// Start with a random list of strings
		String[] input = {"men", "women", "cats", "dogs", "mice", "whales", "cheese", "cheesecrackers"};

		// Use a CurtisSort to sort the list
		CurtisSort sorter = new CurtisSort();
		String[] output = sorter.sort(input);

		// Print out the sorted list
		for(int ctr=0; ctr< output.length; ++ctr) {
			System.out.println(output[ctr]);
		}
	}
}
