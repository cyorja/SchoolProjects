
public class CurtisSort implements Sorter {

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

		int countThrough = 1; 

		while (countThrough != strings.length) { 
			int indexOfSmallest = countThrough - 1;
			String smallest = strings[indexOfSmallest];
			for(int count = countThrough;count < strings.length; count++) {
				if (smallest.compareTo(strings[count]) > 0) {
					smallest = strings[count];
					indexOfSmallest = count;
				}
			}

			System.arraycopy(strings, countThrough - 1, strings, countThrough,indexOfSmallest - (countThrough - 1));
			strings[countThrough - 1] = smallest;
			countThrough++;
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
