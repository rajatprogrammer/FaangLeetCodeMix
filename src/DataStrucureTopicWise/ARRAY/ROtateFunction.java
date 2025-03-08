package DataStrucureTopicWise.ARRAY;
/*
 * https://leetcode.com/problems/rotate-function/description/
 * ou are given an integer array nums of length n.

Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:

F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
Return the maximum value of F(0), F(1), ..., F(n-1).

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [4,3,2,6]
Output: 26
Explanation:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
Example 2:

Input: nums = [100]
Output: 0
 

Constraints:

n == nums.length
1 <= n <= 105
-100 <= nums[i] <= 100
 * 
 * 
 * */
public class ROtateFunction {

	public static void main(String[] args) {
		int nums [] = {4,3,2,6};
		System.out.println(maxRotateFunction(nums));
	}
	
	//full dp solution
	public static int maxRotateFunctionDP (int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int sum = 0, F0 = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A [i];
            F0 += i * A [i];
        }
        int dp [] = new int [A.length];
        dp [0] = F0;
        max = dp [0];
        for (int i = 1; i < A.length; i++) {
            dp [i] = dp [i-1] + sum - A.length * A [A.length - i];
            max = Math.max (max, dp [i]);
        }
        return max;
    }
	
	 public static int maxRotateFunctionOptimizedMemeory(int nums[]) {
		 int maxVal, n = nums.length,F0=0,cur=0,prev,sum=0;
		 for(int i=0;i<nums.length;i++) {
			 sum = sum + nums[i];
			 F0 = F0 + i*nums[i];
		 }
		 maxVal = F0;
		 prev=F0;
		 for(int i=1;i<n;i++) {
			 cur = prev + sum - n*nums[n-i];
			 prev=cur;
			 maxVal = Math.max(cur,maxVal);
		 }
		 return maxVal;
	 }

}
