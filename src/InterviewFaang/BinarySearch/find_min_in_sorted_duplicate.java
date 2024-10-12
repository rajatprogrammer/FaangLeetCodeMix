package BinarySearch;
/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 * */
public class find_min_in_sorted_duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,2,2,0,1};
		System.out.print(findMin(arr));
	}
	 public static int findMin(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }    
	        
	        int left = 0, right = nums.length - 1;
	        while (left+1  < right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] > nums[right]) {
	                left = mid;
	            } else if (nums[mid] < nums[right]) {
	                right = mid;
	            } else {
	                right--;
	            }
	        }
	        if (nums[left] < nums[right]) return nums[left];
	        return nums[right];
	    }


}
