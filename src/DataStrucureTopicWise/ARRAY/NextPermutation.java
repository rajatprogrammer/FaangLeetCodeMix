package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/description/?envType=company&envId=adobe&favoriteSlug=adobe-six-months
public class NextPermutation {
	
	 public static void main(String[] args) {
	        int[] nums = {1, 2, 3};
	        nextPermutation(nums);
	        System.out.println("Next Permutation: " + Arrays.toString(nums));
	    }

	    public static void nextPermutation(int[] nums) {
	        int n = nums.length;

	        // Step 1: Find the first decreasing element
	        int i = n - 2;
	        while (i >= 0 && nums[i] >= nums[i + 1]) {
	            i--;
	        }

	        if (i >= 0) { // If such an element exists
	            // Step 2: Find the smallest element larger than nums[i]
	            int j = n - 1;
	            while (nums[j] <= nums[i]) {
	                j--;
	            }
	            // Swap nums[i] and nums[j]
	            swap(nums, i, j);
	        }

	        // Step 3: Reverse the suffix starting at nums[i+1]
	        reverse(nums, i + 1, n - 1);
	    }

	    // Helper method to swap two elements
	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }

	    // Helper method to reverse a portion of the array
	    private static void reverse(int[] nums, int start, int end) {
	        while (start < end) {
	            swap(nums, start, end);
	            start++;
	            end--;
	        }
	    }

}
