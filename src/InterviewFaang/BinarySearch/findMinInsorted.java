package InterviewFaang.BinarySearch;
/*Find the minimum element in a sorted and rotated array
Difficulty Level : Medium
 Last Updated : 09 Oct, 2020
A sorted array is rotated at some unknown point, find the minimum element in it. 
The following solution assumes that all elements are distinct.

Examples: 

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1
 * **/
public class findMinInsorted {

	public static void main(String[] args) {
		int arr[] = {5, 6, 1, 2, 3, 4};
		System.out.print(findMin(arr,0,arr.length-1));

	}
	static int findMin(int arr[], int low, int high) 
    { 
        // This condition is needed to handle the case when array 
        // is not rotated at all 
        if (high < low)  return arr[0]; 
  
        // If there is only one element left 
        if (high == low) return arr[low]; 
  
        // Find mid 
        int mid = low + (high - low)/2; /*(low + high)/2;*/
  
        // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
        if (mid < high && arr[mid+1] < arr[mid]) 
            return arr[mid+1]; 
  
        // Check if mid itself is minimum element 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return arr[mid]; 
  
        // Decide whether we need to go to left half or right half 
        if (arr[high] > arr[mid]) 
            return findMin(arr, low, mid-1); 
        return findMin(arr, mid+1, high); 
    }
	
	 public int findMin(int[] nums) {
	      int lo = 0, hi = nums.length-1;
	        while (lo < hi) {
	            int mid = lo + (hi-lo)/2;
	            if (nums[mid] < nums[hi]) {
	                hi = mid;
	            } else {
	                lo = mid+1;
	            }
	        }
	        return nums[lo];  
	    }

}
