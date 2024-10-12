package Subarray;

//https://leetcode.com/problems/max-consecutive-ones-iii/
/*
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * */
public class max_consecutive_1 {

	public static void main(String[] args) {
		int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
		int K=2;
		System.out.println(longestOnes(arr,K));
	}
	public static int longestOnes(int[] A, int K) {
        int res = 0, count = 0, n = A.length;
     int i=0;
     for(int j=0; j<n; j++){
         if(A[j]==0){
             count++;
         }
         while(count > K){
             count -= (A[i]==0 ? 1 : 0);
             i++;
         }
         if(count <= K){
            res = Math.max(res, j-i+1);
         }
      }
       return res;
   }
}
