package CompanyWiseLeetcodeGoogle;

import java.util.Arrays;
import java.util.HashMap;

/*
 * https://leetcode.com/problems/3sum-closest/description/
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public static int threeSumClosest(int[] nums, int target) {
	        int diff = Integer.MAX_VALUE;
	        int sz = nums.length;
	        HashMap<Integer, Integer> hs  = new HashMap<>();
	        Arrays.sort(nums);
	        for (int i = 0; i < sz && diff != 0; ++i) {
	            int lo = i + 1;
	            int hi = sz - 1;
	            while (lo < hi) {
	                int sum = nums[i] + nums[lo] + nums[hi];
	                if (Math.abs(target - sum) < Math.abs(diff)) {
	                    diff = target - sum;
	                }
	                if (sum < target) {
	                    ++lo;
	                } else {
	                    --hi;
	                }
	            }
	        }
	        return target - diff;
	    }

}
