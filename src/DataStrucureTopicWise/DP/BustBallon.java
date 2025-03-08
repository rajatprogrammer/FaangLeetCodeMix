package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/burst-balloons/
import java.util.Arrays;

public class BustBallon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxCoins(int[] nums) {
	        int n = nums.length;
	        int[] newNums = new int[n + 2];
	        newNums[0] = newNums[n + 1] = 1;  // Add boundary balloons with value 1

	        for (int i = 0; i < n; i++) {
	            newNums[i + 1] = nums[i];  // Copy nums into newNums with padding
	        }

	        int[][] dp = new int[n + 2][n + 2];
	        for (int[] row : dp) Arrays.fill(row, -1);  // Initialize memoization array

	        return maxCoinsRecursive(newNums, 1, n, dp);
	    }

	    private int maxCoinsRecursive(int[] nums, int left, int right, int[][] dp) {
	        if (left > right) return 0;  // Base case: No balloons left to burst

	        if (dp[left][right] != -1) return dp[left][right];  // Return if already computed

	        int maxCoins = 0;
	        for (int i = left; i <= right; i++) {
	            int coins = nums[left - 1] * nums[i] * nums[right + 1];  // Coins from bursting i
	            coins += maxCoinsRecursive(nums, left, i - 1, dp);  // Left subproblem
	            coins += maxCoinsRecursive(nums, i + 1, right, dp);  // Right subproblem
	            maxCoins = Math.max(maxCoins, coins);
	        }

	        return dp[left][right] = maxCoins;  // Store result in memoization table
	    }

}
