package DataStrucureTopicWise.ARRAY;

/*
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 * Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.

 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 50
 * 
 * 
 * */
public class LongestIncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLen = 1, inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) { inc++; dec = 1; }      // ↗️ Case
            else if (nums[i] < nums[i-1]) { dec++; inc = 1; } // ↘️ Case
            else { inc = 1; dec = 1; }                        // 🟡 Case
            maxLen = Math.max(maxLen, Math.max(inc, dec));    // Update global max
        }
        return maxLen;
    }

}
