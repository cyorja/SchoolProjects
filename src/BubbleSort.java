
public class BubbleSort implements Sorter {

	public int[] sort(int[] ints) {
		boolean switched = true;

		int first = ints[0];
		int second = ints[1];
		for(int listCount=0; switched == true; ++listCount) {
		//while (switched == true) {
			switched = false;			
			for (int count=0; count < ints.length-listCount-1; count++) {
				first = ints[count];
				second = ints[count+1];
				if (first > second) {
					ints[count] = second;
					ints[count+1] = first;
					switched = true;
				}
			}
		}
		return ints;
	}

	public static void main(String[] args) {

		// Start with a random list of ints
		int[] input = {16,25474, 2, 21, 1000, 32000, 163, 0};

		// Use a BubbleSorter to sort the list
		BubbleSort sorter = new BubbleSort();
		int[] output = sorter.sort(input);

		// Print out the sorted list
		for(int ctr=0; ctr< output.length; ++ctr) {
			System.out.println(output[ctr]);
		}
	}
}
