package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Example 1:
	Input: nums = [-4,-1,0,3,10]
	Output: [0,1,9,16,100]
	Explanation: After squaring, the array becomes [16,1,0,9,100].
	After sorting, it becomes [0,1,9,16,100].
	Example 2:
	Input: nums = [-7,-3,2,3,11]
	Output: [4,9,9,49,121]
 * */
public class SquareOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}
	
	public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;        
    }

}
