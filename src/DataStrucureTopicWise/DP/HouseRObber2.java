package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRObber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];
	        if(nums.length == 2) return Math.max(nums[0], nums[1]);
	        return Math.max(robhelper(nums, 0,nums.length-1),robhelper(nums, 1,nums.length));
    }
	 public static int robhelper(int[] nums, int start, int end) {
	        int dp[] = new int[end-start];
	        dp[0]=nums[start];
	        dp[1]=Math.max(dp[0], nums[start+1]);
	        for(int i=start+2;i<end;i++) {
	        	dp[i-start] = Math.max(dp[i-start-2]+nums[i], dp[i-start-1]);
	        }
	        return dp[dp.length-1];
	   }

}
