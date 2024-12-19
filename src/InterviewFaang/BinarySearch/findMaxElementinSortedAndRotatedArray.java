package InterviewFaang.BinarySearch;
/*
 * https://www.geeksforgeeks.org/maximum-element-in-a-sorted-and-rotated-array/?ref=rp
 * https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated-using-binary-search/?ref=rp
 * */
public class findMaxElementinSortedAndRotatedArray {

	static int findMax(int arr[], int low, int high) 
	{ 
	  
	    // This condition is for the case when 
	    // array is not rotated at all 
	    if (high < low) 
	        return arr[0]; 
	  
	    // If there is only one element left 
	    if (high == low) 
	        return arr[low]; 
	  
	    // Find mid 
	    int mid = low + (high - low) / 2; 
	  
	    // Check if mid itself is maximum element 
	    if (mid < high && arr[mid + 1] < arr[mid]) 
	    { 
	        return arr[mid]; 
	    } 
	  
	    // Check if element at (mid - 1) is maximum element 
	    // Consider the cases like {4, 5, 1, 2, 3} 
	    if (mid > low && arr[mid] < arr[mid - 1]) 
	    { 
	        return arr[mid - 1]; 
	    } 
	  
	    // Decide whether we need to go to 
	    // the left half or the right half 
	    if (arr[low] > arr[mid]) 
	    { 
	        return findMax(arr, low, mid - 1); 
	    } 
	    else 
	    { 
	        return findMax(arr, mid + 1, high); 
	    } 
	} 
	  
	// Driver code 
	public static void main(String[] args) 
	{ 
	    int arr[] = { 5, 6, 1, 2, 3, 4 }; 
	    int n = arr.length; 
	    System.out.println(findMax(arr, 0, n - 1)); 
	} 

}
