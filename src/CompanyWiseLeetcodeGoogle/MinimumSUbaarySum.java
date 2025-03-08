package CompanyWiseLeetcodeGoogle;
/*
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 * */
import java.util.Stack;

public class MinimumSUbaarySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2,4};
		System.out.println(sumSubarrayMins(arr));
	}
	
	public static int sumSubarrayMins(int[] arr) {
        long sum=0;
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            left[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = arr.length - 1; i >= 0; i--) {  
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            right[i]=st.isEmpty()?arr.length-i:st.peek()-i;
            st.push(i);
        }
        st.clear();
        for(int i=0;i<arr.length;i++)
        {
             sum = (sum + (long) left[i] * right[i] * arr[i]) % mod;
        }
        return (int)sum;
        
	}        
}
