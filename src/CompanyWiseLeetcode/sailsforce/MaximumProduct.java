package CompanyWiseLeetcode.sailsforce;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 * 628. Maximum Product of Three Numbers
Solved
Easy
Topics
Companies
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 * */
public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maximumProduct(int[] nums) {
	        Arrays.sort(nums);
	        int n = nums.length;
	        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3],
	                        nums[0] * nums[1] * nums[n - 1]);
	    }

}
