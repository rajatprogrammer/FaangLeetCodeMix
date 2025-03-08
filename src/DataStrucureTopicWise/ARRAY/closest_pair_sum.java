package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

/*
 * closest pair sum to zero
 * */
public class closest_pair_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] closestPairToZero(int[] arr) {
        Arrays.sort(arr);    // O(n log n) sorting

        int left = 0, right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];

            // Update closest pair
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            // Move pointers
            if (sum < 0) {
                left++;  // Increase sum
            } else {
                right--; // Decrease sum
            }
        }
        return result;
    }
	
	

}
