package DataStrucureTopicWise.DP;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/split-array-largest-sum/description/
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 * */
public class SPlitArrayLarge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
private int[][] memo;
    
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(nums, 0, k);
    }
    
    private int dp(int[] nums, int index, int k) {
        if (k == 1) {
            return sum(nums, index, nums.length - 1);
        }
        
        if (memo[index][k] != -1) {
            return memo[index][k];
        }
        
        int minLargestSum = Integer.MAX_VALUE;
        
        for (int i = index; i < nums.length - (k - 1); i++) {
            int currentSum = sum(nums, index, i);
            int largestSum = Math.max(currentSum, dp(nums, i + 1, k - 1));
            minLargestSum = Math.min(minLargestSum, largestSum);
            
            if (currentSum > minLargestSum) {
                break;
            }
        }
        
        memo[index][k] = minLargestSum;
        return minLargestSum;
    }

    private int sum(int[] nums, int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += nums[i];
        }
        return total;
    }

}
