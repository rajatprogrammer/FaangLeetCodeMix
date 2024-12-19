package DataStrucureTopicWise.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/
/*Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * */
public class TripletSequqence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean increasingTriplet(int[] nums) {
	       int dp[] = new int [nums.length+1];
	       Arrays.fill(dp,1);
	        for(int i=0;i<nums.length;i++){
	            for(int j=0;j<i;j++){
	                if(nums[j]<nums[i] && dp[i]<dp[j]+1){
	                    dp[i]=dp[j]+1;
	                    if(dp[i]>=3){
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }

	public boolean increasingTripletL(int[] nums) {
	    int first_num = Integer.MAX_VALUE;
	    int second_num = Integer.MAX_VALUE;
	    for (int n: nums) {
	        if (n <= first_num) {
	            first_num = n;
	        } else if (n <= second_num) {
	            second_num = n;
	        } else {
	            return true;
	        }
	    }
	    return false;
	}
	
	

}
