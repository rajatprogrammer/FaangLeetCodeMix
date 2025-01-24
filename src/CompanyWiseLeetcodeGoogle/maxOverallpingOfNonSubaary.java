package CompanyWiseLeetcodeGoogle;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * */
public class maxOverallpingOfNonSubaary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,2,6,7,5,1};
		int k=2;
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(arr,k)));
	}
	
	 public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	        int n = nums.length;

	        // Step 1: Calculate sliding window sums
	        int[] sums = new int[n - k + 1];
	        int windowSum = 0;
	        for (int i = 0; i < n; i++) {
	            windowSum += nums[i];
	            if (i >= k - 1) {
	                sums[i - k + 1] = windowSum;
	                windowSum -= nums[i - k + 1];
	            }
	        }

	        // Step 2: Precompute left max sums
	        int[] left = new int[sums.length];
	        int leftMaxIndex = 0;
	        for (int i = 0; i < sums.length; i++) {
	            if (sums[i] > sums[leftMaxIndex]) {
	                leftMaxIndex = i;
	            }
	            left[i] = leftMaxIndex;
	        }

	        // Step 3: Precompute right max sums
	        int[] right = new int[sums.length];
	        int rightMaxIndex = sums.length - 1;
	        for (int i = sums.length - 1; i >= 0; i--) {
	            if (sums[i] >= sums[rightMaxIndex]) {
	                rightMaxIndex = i;
	            }
	            right[i] = rightMaxIndex;
	        }

	        // Step 4: Find the max sum
	        int maxSum = 0;
	        int[] result = new int[3];
	        for (int mid = k; mid < sums.length - k; mid++) {
	            int l = left[mid - k], r = right[mid + k];
	            int totalSum = sums[l] + sums[mid] + sums[r];
	            if (totalSum > maxSum) {
	                maxSum = totalSum;
	                result = new int[] {l, mid, r};
	            }
	        }

	        return result;
	    }

}
