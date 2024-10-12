package DP;
//https://www.geeksforgeeks.org/subset-sum-problem-osum-space/?ref=rp
//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class subset_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		System.out.print(isSubsetSumDp(arr,sum));
	}

	static boolean isSubsetSumDp(int set[], int sum) {

		boolean dp[][] = new boolean[set.length+1][sum+1];
		for(int i=0;i<=set.length;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j-set[i-1]>=0) {
					//first dp[i-1][j-set[i-1]] check current pair and 
					//dp[i-1][j] check already a pair exist
					dp[i][j]=dp[i-1][j-set[i-1]]||dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[set.length][sum];

	}

}
