package DataStrucureTopicWise.Subarray;

/*
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
 * */
public class absoltePrefixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxAbsoluteSum(int[] nums) {
	        int minPrefixSum = 0, maxPrefixSum = 0;
	        int prefixSum = 0;

	        for (int i = 0; i < nums.length; i++) {
	            prefixSum += nums[i];

	            minPrefixSum = Math.min(minPrefixSum, prefixSum);
	            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
	        }

	        return maxPrefixSum - minPrefixSum;
	    }

}
