package DataStrucureTopicWise.ARRAY;
/*
 * find the minimum sum where i<j
 * */
public class find_smallest_diff {

	 public static int findMaxDifference(int[] arr) {
	        if (arr == null || arr.length < 2) {
	            return -1; // Not enough elements to find a difference
	        }

	        int minSoFar = arr[0];  // Initialize minimum element
	        int maxDiff = Integer.MIN_VALUE; // Initialize max difference

	        for (int i = 1; i < arr.length; i++) {
	            maxDiff = Math.max(maxDiff, arr[i] - minSoFar); // Update max difference
	            minSoFar = Math.min(minSoFar, arr[i]); // Update minSoFar
	        }

	        return maxDiff;
	    }

	    public static void main(String[] args) {
	        int[] arr = {1, 4, 5, 6, 7, 9};
	        System.out.println("Max Difference: " + findMaxDifference(arr)); // Output: 8
	    }
	

}
