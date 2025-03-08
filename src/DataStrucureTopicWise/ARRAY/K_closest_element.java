package DataStrucureTopicWise.ARRAY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/find-k-closest-elements/
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]

 
 * 
 * 
 * 
 * 
 * */
public class K_closest_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Convert from array to list first to make use of Collections.sort()
        List<Integer> sortedArr = new ArrayList<Integer>();
        for (int num: arr) {
            sortedArr.add(num);
        }
        
        // Sort using custom comparator
        Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        
        // Only take k elements
        sortedArr = sortedArr.subList(0, k);
        
        // Sort again to have output in ascending order
        Collections.sort(sortedArr);
        return sortedArr;
    }
	
	 public List<Integer> findClosestElementsOptimized(int[] arr, int k, int x) {
         int start =0;
	        int end = arr.length-k;
	        while(start<end) {
	        	int mid = (start + end)/2;
	        	if((x-arr[mid]) > (arr[mid+k]-x)) {
	        		start = mid+1;
	        	}else {
	        		end =mid;  
	        	}
	        }
	        List<Integer> ls = new ArrayList<Integer>();
	        for (int i = start; i < start + k; i++) {
	            ls.add(arr[i]);
	        }
	        return ls;
 }
}
