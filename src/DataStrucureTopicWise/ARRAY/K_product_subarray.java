package DataStrucureTopicWise.ARRAY;

/*
 * https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays
 * Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 

Example 1:

Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The 2 smallest products are:
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
The 2nd smallest product is 8.
Example 2:

Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
Explanation: The 6 smallest products are:
- nums1[0] * nums2[1] = (-4) * 4 = -16
- nums1[0] * nums2[0] = (-4) * 2 = -8
- nums1[1] * nums2[1] = (-2) * 4 = -8
- nums1[1] * nums2[0] = (-2) * 2 = -4
- nums1[2] * nums2[0] = 0 * 2 = 0
- nums1[2] * nums2[1] = 0 * 4 = 0
The 6th smallest product is 0.
Example 3:

Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
Output: -6
Explanation: The 3 smallest products are:
- nums1[0] * nums2[4] = (-2) * 5 = -10
- nums1[0] * nums2[3] = (-2) * 4 = -8
- nums1[4] * nums2[0] = 2 * (-3) = -6
The 3rd smallest product is -6.
 

Constraints:

1 <= nums1.length, nums2.length <= 5 * 104
-105 <= nums1[i], nums2[j] <= 105
1 <= k <= nums1.length * nums2.length
nums1 and nums2 are sorted.
 * 
 * 
 * 
 * */
public class K_product_subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // 1. define search space
        long left = (long)-1e11;
        long right = (long)1e11;
        while(left < right){
            long mid = left + (right - left) / 2;
            if(countSmaller(nums1, nums2, mid) >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // At the end, left is the product that has k smaller products before it, so the kth smallest product is left - 1
        return left - 1;
    }
    
    private long countSmaller(int[] nums1, int[] nums2, long product){
        long count = 0;
        for(int i = 0; i < nums1.length; i++){
            // count all nums2[j] such that nums1[i] * nums2[j] < product
            if(nums1[i] >= 0){
                int left = 0;
                int right = nums2.length;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    // if nums1[i] > 0, find the first occurrence of nums2[j] where nums1[i] * nums2[j] >= product
                    if((long) nums1[i] * nums2[mid] < product){
                        left = mid + 1;
                    } else {
                        right = mid;
                    }   
                }
                count += left;
            } else {
                int left = 0;
                int right = nums2.length;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    // since nums1[i] is negative, nums2 is sorted
                    // nums[j] * nums[i] will be in descending order from [0...nums2.length-1]
                    // take [-4,-2,0,3] as an example, product with a negative number will become smaller if the number gets bigger
                    // want to find the last nums2[j] such that nums1[i] * nums2[j] is not smaller than product
                    if((long) nums1[i] * nums2[mid] >= product){
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += nums2.length - left;
            }
        }
        return count;
    }

}
