package DataStrucureTopicWise.ARRAY;
//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class kadenCircullarArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,-2,3,-2};
		System.out.println(maxSubarraySumCircular(arr));
	}
	
	 public static int maxSubarraySumCircular(int[] nums) {
		    int curMax = 0;
	        int curMin = 0;
	        int maxSum = nums[0];
	        int minSum = nums[0];
	        int totalSum = 0;
	        
	        for (int num: nums) {
	            // Normal Kadane's
	            curMax = Math.max(curMax, 0) + num;
	            maxSum = Math.max(maxSum, curMax);
	            
	            // Kadane's but with min to find minimum subarray
	            curMin = Math.min(curMin, 0) + num;
	            minSum = Math.min(minSum, curMin);
	            
	            totalSum += num;  
	        }

	        if (totalSum == minSum) {
	            return maxSum;
	        }
	        
	        return Math.max(maxSum, totalSum - minSum);
	      }

}
