package DP;

import java.util.Arrays;

//https://www.geeksforgeeks.org/burst-balloon-to-maximize-coins/
//amazon,samsung
//https://leetcode.com/problems/burst-balloons/
public class burstBallon {
	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,5,8};
		burstBallon ob1 = new burstBallon();
		System.out.println(ob1.maxCoins(arr));
		System.out.println(getMax(arr,arr.length));
	}
	//recursive approach
	public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] numbers = new int[len+2];
        System.arraycopy(nums, 0, numbers, 1, len);
        numbers[0] = 1; numbers[len+1] = 1;
        int[][] memo = new int[len+2][len+2];
        for(int i = 0; i < len+2; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(numbers, 1, len, memo);
    }
	private int f(int[] nums, int from, int to, int[][] memo) {
        if(from > to) return 0;
        if(memo[from][to] != -1) {
            return memo[from][to];
        }
        int max = 0;
        for(int j = from; j <= to; j++) {
            int cur = f(nums, from, j-1, memo) + f(nums, j+1, to, memo) +
                nums[from-1] * nums[j] * nums[to+1];
            max = Math.max(max, cur);  
        }
        memo[from][to] = max;
        return max;
    }
	//dp solution
	public static int getMax(int[] A, int N) 
	{ 
		
		// Add Bordering Balloons 
		int[] B = new int[N + 2]; 
		B[0] = B[N + 1] = 1; 
			
		for(int i = 1; i <= N; i++) 
			B[i] = A[i - 1]; 
		
		// Declaring DP array 
		int[][] dp = new int[N + 2][N + 2]; 
		
		for(int length = 1; 
				length < N + 1; length++) 
		{ 
			for(int left = 1; 
					left < N - length + 2; left++) 
			{ 
				int right = left + length -1; 
				
				// For a sub-array from indices 
				// left, right. This innermost 
				// loop finds the last balloon burst 
				for(int last = left; 
						last < right + 1; last++) 
				{ 
					dp[left][right] = Math.max( 
									dp[left][right], 
									dp[left][last - 1] + 
									B[left - 1] * B[last] * 
									B[right + 1] + 
									dp[last + 1][right]); 
				} 
			} 
		} 
		return dp[1][N]; 
	} 

}
