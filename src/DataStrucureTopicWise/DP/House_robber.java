package DataStrucureTopicWise.DP;
// https://leetcode.com/problems/house-robber/
// DP SOLUTION	
public class House_robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,7,1,3,8,2,4};
		System.out.println(rob(arr));
		
	}
	public static int rob(int[] nums) {
		      if(nums.length == 1) return nums[0];
		      int dp[] = new int[nums.length];
		       dp[0] = nums[0];
		       dp[1] = Math.max(dp[0], nums[1]);
		       if(nums.length == 2) return dp[1];
		       for(int i=2;i<nums.length;i++){
		        dp[i] = Math.max(dp[i-1],(nums[i]+dp[i-2]));
		       } 
		      // System.out.println("Array" + Arrays.toString(dp));
		       return dp[nums.length-1];

    }

}
