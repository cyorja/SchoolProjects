import java.util.Arrays;


public class mergeSort {
	
	public static void main(String args[]) {
		mergeSort sorter = new mergeSort();
		int[] test = {4, 7, 1, 8, 4, 0, -100}; // Change these
		
		int[] sorted = sorter.mergeSort(test);
		System.out.println(Arrays.asList(sorted).toString());
	}
	
	public int[] mergeSort ( int [] numbers) {
		
		if (numbers.length <= 1) {
			return numbers;
		}
		
		int[] numbersOne = firstHalf(numbers);
		int[] numbersTwo = secondHalf(numbers);
		
		numbersOne = mergeSort(numbersOne);
		numbersTwo = mergeSort(numbersTwo);
		
		int[] sorted = merge (numbersOne, numbersTwo);
		return sorted;
	}
	
	public int[] firstHalf ( int [] numbers) {
		int[] copy = new int[numbers.length/2];
		System.arraycopy(numbers, 0, copy, 0, numbers.length/2);
		return copy;
	}
	
	public int[] secondHalf ( int [] numbers ) {
		//Do this like above
		int[] copy = new int[numbers.length/2];
		System.arraycopy(numbers, numbers.length/2, copy, 0, numbers.length/2);
		return copy;
	}
	
	public int[] merge ( int [] numbersOne, int [] numbersTwo ) {
		int[] merger = new int[numbersOne.length + numbersTwo.length];
		int markerOne = 0;
		int markerTwo = 0;
		while (! (markerOne >= numbersOne.length || markerTwo >= numbersTwo.length)) {
			if (numbersOne[markerOne] > numbersTwo[markerTwo]) {
				merger[markerOne+markerTwo] = numbersOne[markerOne];
				markerOne++;
			} else {
				merger[markerOne+markerTwo] = numbersTwo[markerTwo];
				markerTwo++;
			}	
		}
		if (markerOne >= numbersOne.length) {
			// Copy what is left in numbersTwo into merger
			System.arraycopy(arg0, arg1, arg2, arg3, arg4);
		} else {
			// fill this in
		}
		
		return merger;
	}	
	
}
