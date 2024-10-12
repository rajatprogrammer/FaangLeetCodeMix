package Subarray;

//https://leetcode.com/problems/subarray-product-less-than-k/
/**
 * 
 * @author rajat Your are given an array of positive integers nums.
 * 
 *         Count and print the number of (contiguous) subarrays where the
 *         product of all the elements in the subarray is less than k.
 * 
 *         Example 1: Input: nums = [10, 5, 2, 6], k = 100 Output: 8
 *         Explanation: The 8 subarrays that have product less than 100 are:
 *         [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]. Note that
 *         [10, 5, 2] is not included as the product of 100 is not strictly less
 *         than k.
 */
public class k_product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,5,2,6};
		int k=100;
		System.out.print(numSubarrayProductLessThanK(arr,k));
	}
	 public static int numSubarrayProductLessThanK(int[] nums, int k) {
	        if (k == 0) return 0;
	        int result = 0, i = 0, itr = 0, product = 1;
	        for( itr=0;itr<nums.length;itr++) {
	        	product = product * nums[itr];
	        	while(product>=k && i<=itr) {
	        		product = product/nums[i++];
	        	}
	        	result = result + (itr-i +1);
	        }
	        return result;
	    }

}
