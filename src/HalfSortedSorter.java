
public class HalfSortedSorter implements Sorter {

	public int[] sort(int[] ints) {
		int[] less = new int[ints.length];
		int numInLess = 0;
		int[] more = new int[ints.length];
		int numInMore = 0;
		
		int mid = ints[0];
		
		for(int ctr=1; ctr<ints.length; ++ctr) {
			if (mid > ints[ctr]) {
				less[numInLess] = ints[ctr];
				++numInLess;
			} else {
				more[numInMore] = ints[ctr];
				++numInMore;
			}
		}
		
		less[numInLess] = mid;
		System.arraycopy(more, 0, less, numInLess+1, numInMore);
		return less;
	}
	
	public static void main(String[] args) {

		// Start with a random list of ints
		int[] input = {16,25474, 2, 21, 1000, 32000, 163, 0};

		// Use a BubbleSorter to sort the list
		Sorter sorter = new HalfSortedSorter();
		int[] output = sorter.sort(input);

		// Print out the sorted list
		for(int ctr=0; ctr< output.length; ++ctr) {
			System.out.println(output[ctr]);
		}
	}

}
