package InterviewFaang.DP;
//https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
public class countSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 34, 4, 12, 5, 2};
		int sum=9;
		System.out.print(countWaysForSum(arr,sum));
	}
	public static int countWaysForSum(int[] nums, int S) {
        int[][] dp = new int[nums.length+1][S+1];
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                if(j==0) {
                    dp[i][j] = 1;
                }
            }
        }
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(nums[i-1]==0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {   
                    if(nums[i-1] <= j) {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[nums.length][S];
    }
	
	
	 public static int countSubsets(int[] arr, int n, int sum) {
	        // Base Cases
	        if (sum == 0) {
	            return 1;
	        }
	        if (n == 0) {
	            return 0;
	        }
	        
	        // If the last element is greater than the sum, ignore it
	        if (arr[n - 1] > sum) {
	            return countSubsets(arr, n - 1, sum);
	        }
	        
	        // Either include the last element or exclude it
	        return countSubsets(arr, n - 1, sum) + countSubsets(arr, n - 1, sum - arr[n - 1]);
	    }



}
