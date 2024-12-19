package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/count-number-of-teams/
public class checkThing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rating [] = {2,5,3,4,1};
		System.out.println(numTeams(rating));
	}
	
	 public static int numTeams(int[] rating) {
	        int n = rating.length;

	        int[][] dp = new int[n][2];
	        int count = 0;

	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (rating[i] > rating[j]) {
	                    dp[i][0]++;
	                    count += dp[j][0];
	                } else if (rating[i] < rating[j]) {
	                    dp[i][1]++;
	                    count += dp[j][1];
	                }
	            }
	        }
	        
	        return count;
	    }
}
