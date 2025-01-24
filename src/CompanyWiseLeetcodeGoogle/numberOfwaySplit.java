package CompanyWiseLeetcodeGoogle;
/*
 * https://leetcode.com/problems/number-of-ways-to-split-array
 * 2270. Number of Ways to Split Array
You are given a 0-indexed integer array nums of length n.

nums contains a valid split at index i if the following are true:

The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
There is at least one element to the right of i. That is, 0 <= i < n - 1.
Return the number of valid splits in nums.

 * 
 * */
public class numberOfwaySplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {10,4,-8,7};
		System.out.println(waysToSplitArray(nums));
	}
	
	public static int waysToSplitArray(int[] nums) {
        long leftsum =0;
        long rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int count=0;

        for(int i=0;i<nums.length-1;i++){
            leftsum = leftsum + nums[i];
            rightSum = rightSum - nums[i];

            if(leftsum>=rightSum){
                count++;
            }
        }
        return count;

    }

}
