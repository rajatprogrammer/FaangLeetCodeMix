package InterviewFaang.Array;
//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
/*You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
 * */
public class minimumoperation_reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {3,2,20,1,1,3};
		int x=10;
		System.out.println(minOperations(nums,x));
	}

	public static int minOperations(int[] nums, int x) {
        int current = 0;
        for (int num : nums) {
            current += num;
        }
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // sum([0,..,left) + (right,...,n-1]) = x
            current -= nums[right];
            // if smaller, move `left` to left
            while (current < x && left <= right) {
                current += nums[left];
                left += 1;
            }
            // check if equal
            if (current == x) {
                mini = Math.min(mini, (n-1-right)+left);
            }
        }
        return mini != Integer.MAX_VALUE ? mini : -1;
    }
}
