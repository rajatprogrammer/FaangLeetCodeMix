package DataStrucureTopicWise.DP;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-2/
//https://www.geeksforgeeks.org/coin-change-dp-7/
public class coinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {1,2,5};
		int amount=5;
		Integer dp[][] = new Integer[coins.length][amount+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.print(coinChange(coins,0,amount,dp));
		System.out.print(changeCheck(amount,coins));
	}
	
	static int  coinChange(int[]coins,int i,int amount,Integer dp[][]) {
		if(amount==0) {
			return 1;
		}else if(amount<0 || coins.length<=i) {
			return 0;
		}else if(dp[i][amount]!=-1){
			return dp[i][amount];
		}
		else {
			dp[i][amount] = coinChange(coins,i,amount-coins[i],dp) + coinChange(coins,i+1,amount,dp);
		}
		return amount;
	}
	
	public static int changeCheck(int amount, int[] coins) {
        int n = coins.length;
        long[] dp = new long[amount + 1]; // Use long to avoid overflow
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount] <= Integer.MAX_VALUE ? (int) dp[amount] : -1; // Return -1 if result exceeds int limit
    }
	
	public int coinChange(int[] coins, int amount) {
	    int max = amount + 1;
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, max);
	    dp[0] = 0;
	    for (int i = 1; i <= amount; i++) {
	      for (int j = 0; j < coins.length; j++) {
	        if (coins[j] <= i) {
	          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	        }
	      }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	  }

}
