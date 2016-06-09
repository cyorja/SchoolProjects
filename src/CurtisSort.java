
public class CurtisSort implements Sorter {

	public int[] sort(int[] ints) {
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

		while (countThrough != ints.length) { 
			int indexOfSmallest = countThrough - 1;
			int smallest = ints[indexOfSmallest];
			for(int count = countThrough;count < ints.length; count++) {
				if (smallest > ints[count]) {
					smallest = ints[count];
					indexOfSmallest = count;
				}
			}

			System.arraycopy(ints, countThrough - 1, ints, countThrough,indexOfSmallest - (countThrough - 1));
			ints[countThrough - 1] = smallest;
			countThrough++;
		}
		return ints;
	}

	public static void main(String[] args) {

		// Start with a random list of ints
		int[] input = {16,25474, 2, 21, 1000, 32000, 163, 0};

		// Use a CurtisSort to sort the list
		CurtisSort sorter = new CurtisSort();
		int[] output = sorter.sort(input);

		// Print out the sorted list
		for(int ctr=0; ctr< output.length; ++ctr) {
			System.out.println(output[ctr]);
		}
	}
}
