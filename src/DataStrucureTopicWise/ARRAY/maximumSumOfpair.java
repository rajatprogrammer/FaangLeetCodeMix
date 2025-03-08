package DataStrucureTopicWise.ARRAY;

/*
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
 * ou are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
 * 
 * 
 * */
public class maximumSumOfpair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int nums[] = {18,43,36,13,7};
			System.out.println(maximumSum(nums));
	}
	
	 public static int maximumSum(int[] nums) {
	        int result = -1;
	        // Array to map digit sums to the largest element with that sum
	        // (82 to cover all possible sums from 0 to 81)
	        int[] digitMapping = new int[82];

	        for (int element : nums) {
	            int digitSum = 0;
	            // Calculating digit sum
	            for (int currValue = element; currValue != 0; currValue /= 10) {
	                int currDigit = currValue % 10;
	                digitSum += currDigit;
	            }

	            // Check if there is already an element with the same digit sum
	            if (digitMapping[digitSum] > 0) {
	                // Update the result if the sum of the current and mapped element is greater
	                result = Math.max(result, digitMapping[digitSum] + element);
	            }

	            // Update the mapping to store the larger of the current or previous element for this digit sum
	            digitMapping[digitSum] = Math.max(digitMapping[digitSum], element);
	        }

	        return result;
	    }

}
