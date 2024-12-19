package InterviewFaang.DP;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class subsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 34, 4, 12, 5, 2};
		int sum=9;
		System.out.println(isSubsetSumRecusrive(arr,arr.length,sum));
		System.out.println(isSubsetSumDP(arr,sum));
	}

	static boolean isSubsetSumRecusrive(int set[], int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (set[n - 1] > sum)
			return isSubsetSumRecusrive(set, n - 1, sum);
		return isSubsetSumRecusrive(set, n - 1, sum) || isSubsetSumRecusrive(set, n - 1, sum - set[n - 1]);
	}
	static boolean isSubsetSumDP(int arr[],int S) {
		  boolean dp[][] = new boolean[arr.length+1][S+1];
		  for(int i=0;i<arr.length;i++) {
			  dp[i][0]=true;
		  }
		  for(int i=1;i<=arr.length;i++) {
			  for(int j=0;j<=S;j++) {
				  if(j-arr[i-1]>=0) {
					  dp[i][j] = dp[i-1][j-arr[i-1]]|| dp[i-1][j];
				  }else {
					  dp[i][j] = dp[i-1][j];
				  }
			  }
		  }	  
		  return dp[arr.length][S];
	}

}
