package DataStrucureTopicWise.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/
public class MinDIfference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDifference(int[] nums) {
        int numsSize = nums.length;

        // If the array has 4 or fewer elements, return 0
        if (numsSize <= 4) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Four scenarios to compute the minimum difference
        for (int left = 0, right = numsSize - 4; left < 4; left++, right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }

        return minDiff;
    }

}
