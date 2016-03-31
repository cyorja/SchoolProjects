
public class BubbleSort {

	public String[] sort(String[] strings) {
		boolean switched = true;

		String first = strings[0];
		String second = strings[1];
		int count = 0;
		while (switched == true) {
			count = 0;
			switched = false;
			while (count < strings.length-1) {
				first = strings[count];
				second = strings[count+1];
				if (first.compareTo(second) > 0) {
					strings[count] = second;
					strings[count+1] = first;
					switched = true;
				}
				count++;
			}
		}
		return strings;
	}

	public static void main(String[] args) {

		// Start with a random list of strings
		String[] input = {"men", "women", "cats", "dogs", "mice", "whales", "cheese", "cheesecrackers"};

		// Use a BubbleSorter to sort the list
		BubbleSort sorter = new BubbleSort();
		String[] output = sorter.sort(input);

		// Print out the sorted list
		for(int ctr=0; ctr< output.length; ++ctr) {
			System.out.println(output[ctr]);
		}
	}
}
