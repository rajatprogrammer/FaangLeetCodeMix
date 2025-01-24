package InterviewFaang.DP;

import java.util.Arrays;
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class longest_increasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		  System.out.print("Length of LIS is "
                  + lengthOfLIS(arr));
		  System.out.print("Length of LIS is "
                  + LIS(arr,0,arr.length,Integer.MIN_VALUE));
	}
	
	 public static int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        Arrays.fill(dp, 1);
	        
	        for (int i = 1; i < nums.length; i++) {
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	        }
	        
	        int longest = 0;
	        for (int c: dp) {
	            longest = Math.max(longest, c);
	        }
	        
	        return longest;
	    }
	
	public static  int LIS(int[] A, int i, int n, int prev)
    {
        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = LIS(A, i + 1, n, prev);
 
        // case 2: include the current element if it is greater
        // than previous element in LIS
        int incl = 0;
        if (A[i] > prev) {
            incl = 1 + LIS(A, i + 1, n, A[i]);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }

}
