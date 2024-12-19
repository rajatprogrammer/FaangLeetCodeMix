package DataStrucureTopicWise.DP;
//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubSetSUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	 static boolean isSubsetSumRec(int[] arr, int n, int sum) {
	      
	        // Base Cases
	        if (sum == 0) {
	            return true;
	        }
	        if (n == 0) {
	            return false;
	        }

	        // If last element is greater than 
	          // sum, ignore it
	        if (arr[n - 1] > sum) {
	            return isSubsetSumRec(arr, n - 1, sum);
	        }

	        // Check if sum can be obtained by including 
	          // or excluding the last element
	        return isSubsetSumRec(arr, n - 1, sum) || 
	               isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);
	    }
	 
	 static boolean isSubsetSumRec(int[] arr, int n, int sum,
             int[][] memo) 
	 {

		// If the sum is zero, we found a subset
		if (sum == 0) {
		return true;
		}
		
		// If no elements are left
		if (n <= 0) {
		return false;
		}
		
		// If the value is already computed, return it
		if (memo[n][sum] != -1) {
		return memo[n][sum] == 1;
		}
		
		// If the last element is greater than the sum,
		// ignore it
		if (arr[n - 1] > sum) {
		memo[n][sum] = isSubsetSumRec(arr, n - 1, sum, memo) 
		      ? 1 : 0;
		}
		else {
		
		// Include or exclude the last element directly
		memo[n][sum] = (isSubsetSumRec(arr, n - 1, sum, memo)
		|| isSubsetSumRec(arr, n - 1, sum - arr[n - 1], memo))
		 ? 1 : 0;
		}
		
		return memo[n][sum] == 1;
	 }
	 
	 static boolean isSubsetSumDP(int[] arr, int sum) {
	        int n = arr.length;

	        // Create a 2D array for storing results of
	        // subproblems
	        boolean[][] dp = new boolean[n + 1][sum + 1];

	        // If sum is 0, then answer is true
	          // (empty subset)
	        for (int i = 0; i <= n; i++) {
	            dp[i][0] = true;
	        }

	        // Fill the dp table in bottom-up manner
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= sum; j++) {
	                if (j < arr[i - 1]) {
	                  
	                    // Exclude the current element
	                    dp[i][j] = dp[i - 1][j];
	                }
	                else {
	                  
	                    // Include or exclude
	                    dp[i][j] = dp[i - 1][j]
	                               || dp[i - 1][j - arr[i - 1]];
	                }
	            }
	        }

	        return dp[n][sum];
	    }


}
