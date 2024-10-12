package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
//https://leetcode.com/problems/3sum/
 //amazon

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 * */
public class ThreeSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(arr));
		
	}
	 public static List<List<Integer>> threeSum(int[] nums) {
		 if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
	        Arrays.sort(nums); // sort array
	        Set<List<Integer>> set = new HashSet<>();
	        for (int i = 0; i < nums.length - 2; i++) {
	            int j = i + 1;
	            int k = nums.length - 1;
	            while (j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
	                else if (sum > 0) k--;
	                else if (sum < 0) j++;
	            }

	        }
	        return new ArrayList<>(set);
    
	 }

}
