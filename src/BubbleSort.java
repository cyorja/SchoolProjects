
public class BubbleSort implements Sorter {

	public String[] sort(String[] strings) {
		boolean switched = true;

		String first = strings[0];
		String second = strings[1];
		for(int listCount=0; switched == true; ++listCount) {
		//while (switched == true) {
			switched = false;			
			for (int count=0; count < strings.length-listCount-1; count++) {
			//for (int count=0; count < strings.length-1; count++) {
				first = strings[count];
				second = strings[count+1];
				if (first.compareTo(second) > 0) {
					strings[count] = second;
					strings[count+1] = first;
					switched = true;
				}
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
