package Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*Sum of minimum and maximum elements of all subarrays of size k.
 *https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
Difficulty Level : Hard
 Last Updated : 15 Jan, 2021
Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
Examples: 
 

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
        K = 4
Output : 18
Explanation : Subarrays of size 4 are : 
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4      
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4   
     Sum of all min & max = 6 + 4 + 4 + 4 
                          = 18  
 * */
public class minimum_maximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2, 5, -1, 7, -3, -1, -2};
		int k=4;
		System.out.println(SumOfKsubArray(arr,arr.length,k));
	}
	static int SumOfKsubArray(int arr[] , int n , int k) {
		Deque<Integer> S = new LinkedList<Integer>(),G = new LinkedList<Integer>();
		int i,sum=0;
		for (i = 0; i < k; i++) 
        { 
            // Remove all previous greater elements 
            // that are useless. 
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i]) 
                S.removeLast(); // Remove from rear 
   
            // Remove all previous smaller that are elements 
            // are useless. 
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i]) 
                G.removeLast(); // Remove from rear 
   
            // Add current element at rear of both deque 
            G.addLast(i); 
            S.addLast(i); 
        } 
   
        // Process rest of the Array elements 
        for (  ; i < arr.length; i++ ) 
        { 
            // Element at the front of the deque 'G' & 'S' 
            // is the largest and smallest 
            // element of previous window respectively 
            sum += arr[S.peekFirst()] + arr[G.peekFirst()]; 
   
            // Remove all elements which are out of this 
            // window 
            while ( !S.isEmpty() && S.peekFirst() <= i - k) 
                S.removeFirst(); 
            while ( !G.isEmpty() && G.peekFirst() <= i - k) 
                G.removeFirst(); 
   
            // remove all previous greater element that are 
            // useless 
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i]) 
                S.removeLast(); // Remove from rear 
   
            // remove all previous smaller that are elements 
            // are useless 
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i]) 
                G.removeLast(); // Remove from rear 
   
            // Add current element at rear of both deque 
            G.addLast(i); 
            S.addLast(i); 
        } 
   
        // Sum of minimum and maximum element of last window 
        sum += arr[S.peekFirst()] + arr[G.peekFirst()]; 
   
        return sum; 
   
	}

}
