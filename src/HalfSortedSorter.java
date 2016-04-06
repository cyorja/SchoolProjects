
public class HalfSortedSorter implements Sorter {

	public String[] sort(String[] strings) {
		String[] less = new String[strings.length];
		int numInLess = 0;
		String[] more = new String[strings.length];
		int numInMore = 0;
		
		String mid = strings[0];
		
		for(int ctr=1; ctr<strings.length; ++ctr) {
			if (mid.compareTo(strings[ctr]) > 0) {
				less[numInLess] = strings[ctr];
				++numInLess;
			} else {
				more[numInMore] = strings[ctr];
				++numInMore;
			}
		}
		
		less[numInLess] = mid;
		System.arraycopy(more, 0, less, numInLess+1, numInMore);
		return less;
	}
}
