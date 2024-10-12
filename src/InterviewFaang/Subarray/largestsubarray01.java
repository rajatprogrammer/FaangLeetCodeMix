package Subarray;

import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n). 
Examples: 

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 
(Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

 * */
public class largestsubarray01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
	        int n = arr.length;
	 
	        System.out.print(largestsubarray01.maxLen(arr, n));
	}
	
	static int maxLen(int arr[], int n)
    {
        // Creates an empty hashMap hM
 
        HashMap<Integer, Integer> hM
            = new HashMap<Integer, Integer>();
 
        // Initialize sum of elements
        int sum = 0;
 
        // Initialize result
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;
 
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
 
        // Traverse through the given array
 
        for (int i = 0; i < n; i++) {
            // Add current element to sum
 
            sum += arr[i];
 
            // To handle sum=0 at last index
 
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }
 
            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }
 
 
        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);
 
        return max_len;
    }
 
}
