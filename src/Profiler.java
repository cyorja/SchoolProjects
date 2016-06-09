import java.util.ArrayList;

public class Profiler {

	public static class Result {
		public int numEntries;
		public long milliseconds;
	}
	
	private int STARTING_NUM_ENTRIES = 100;
	
	private long RUN_TIME = 1 * 60 * 1000; // 5 minutes in milliseconds
	
	private Sorter sorter;
	
	private ArrayList<Result> results;
	
	public Profiler(Sorter inSorter) {
		sorter = inSorter;
	}
	
	public void profile() {
				
		results = new ArrayList<Result>();
		
		long simStart = System.currentTimeMillis();
		long simEnd = simStart + RUN_TIME;
		int numEntries = STARTING_NUM_ENTRIES;
		
		while (System.currentTimeMillis() < simEnd) {
			Result nextResult = profileSortWithSize(numEntries);
			printResultAtSize(numEntries, nextResult);
			results.add(nextResult);
			numEntries = numEntries * 2;
		}
	}
	
	private Result profileSortWithSize(int numEntries) {
		int NUM_RUNS = 3;
		Result totalResult = new Result();
		totalResult.numEntries = numEntries;
		totalResult.milliseconds = 0;
		for(int ctr=0; ctr<NUM_RUNS; ++ctr) {
			Result nextResult = runOneSortWithSize(numEntries);
			totalResult.milliseconds += nextResult.milliseconds;
		}
		totalResult.milliseconds /= NUM_RUNS;
		return totalResult;
	}
	
	private Result runOneSortWithSize(int numEntries) {
		String[] randomList = generateRandomList(numEntries);
		long sortStart = System.currentTimeMillis();
		sorter.sort(randomList); // Don't even care about the returned sorted list
		long sortEnd = System.currentTimeMillis();
		Result nextResult = new Result();
		nextResult.numEntries = numEntries;
		nextResult.milliseconds = sortEnd - sortStart;
		return nextResult;
	}
	
	
	
	private void printResultAtSize(int numEntries, Result nextResult) {
		System.out.print(numEntries + "...");
		if (nextResult.milliseconds < 1000) {
			System.out.print(nextResult.milliseconds + "ms");
		} else {
			System.out.print(nextResult.milliseconds/1000.0 + "sec");
		}
		if (!results.isEmpty() && (results.get(results.size()-1).milliseconds > 0)) {
			double factor = ((double)nextResult.milliseconds) / results.get(results.size()-1).milliseconds;
			System.out.print(" (x" + factor + ")");
		}
		System.out.println();
	}
	
	public void printResults() {
		for(Result nextResult : results) {
			System.out.println(nextResult.numEntries + " = " + nextResult.milliseconds + "ms");
		}
	}
	
	private String[] generateRandomList(int numEntries) {
		int NUM_CHARS_IN_EACH_STRING = 20;
		char MAX_CHAR = 'j';
		
		int maxRandomInt = MAX_CHAR-'a'+1;
		ArrayList<String> randomList = new ArrayList<String>(numEntries);
		for(int stringCtr=0; stringCtr<numEntries; ++stringCtr) {
			StringBuffer buffer = new StringBuffer(10);
			for(int charCtr=0; charCtr<NUM_CHARS_IN_EACH_STRING; ++charCtr) {
				int randomInt = (int)(Math.random() * maxRandomInt);
				char randomChar = (char) ('a'+randomInt);
				buffer.append(randomChar);
			}
			randomList.add(buffer.toString());
		}
		return randomList.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		Sorter hsort = new MergeSort();
		Profiler profiler = new Profiler(hsort);
		profiler.profile();
	}
}
