import java.util.Arrays;


public class MergeSort implements Sorter {
	
	public static void main(String args[]) {
		MergeSort sorter = new MergeSort();
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 0}; // Change these
		
		int[] sorted = sorter.mergeSort(test);
		for(int x : sorted) {
			System.out.print(x + " ");
		}
		System.out.println();
		//System.out.println(Arrays.asList(sorted).toString());
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
		int[] copy = new int[numbers.length - numbers.length/2];
		System.arraycopy(numbers, numbers.length/2, copy, 0, numbers.length - numbers.length/2);
		return copy;
	}
	
	public int[] merge ( int [] numbersOne, int [] numbersTwo ) {
		int[] merger = new int[numbersOne.length + numbersTwo.length];
		int markerOne = 0;
		int markerTwo = 0;
		while (! (markerOne >= numbersOne.length || markerTwo >= numbersTwo.length)) {
			if (numbersOne[markerOne] <= numbersTwo[markerTwo]) {
				merger[markerOne+markerTwo] = numbersOne[markerOne];
				markerOne++;
			} else {
				merger[markerOne+markerTwo] = numbersTwo[markerTwo];
				merger[markerOne+markerTwo] = numbersTwo[markerTwo];
				markerTwo++;
			}	
		}
		if (markerOne >= numbersOne.length) {
			System.arraycopy(numbersTwo,  markerTwo, merger, markerOne + markerTwo, numbersTwo.length - markerTwo);
		} else {
			System.arraycopy(numbersOne, markerOne, merger, markerOne + markerTwo, numbersOne.length - markerOne);
		}
		
		return merger;
	}	
	
}
