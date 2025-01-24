package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/count-different-palindromic-subsequences/description/
//tricky
public class countdifferentpalindromicsubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countPalindromicSubsequences(String s) {
		  int MOD = 1_000_000_007;
	        int n = s.length();
	        int[][] dp = new int[n][n];
	        
	        // Base case: single character substrings
	        for (int i = 0; i < n; i++) {
	            dp[i][i] = 1;
	        }
	        
	        // Iterate over substring lengths
	        for (int length = 2; length <= n; length++) {
	            for (int i = 0; i <= n - length; i++) {
	                int j = i + length - 1;
	                if (s.charAt(i) == s.charAt(j)) {
	                    int low = i + 1, high = j - 1;
	                    
	                    // Find the first and last occurrence of s[i] in s[i+1:j]
	                    while (low <= high && s.charAt(low) != s.charAt(i)) {
	                        low++;
	                    }
	                    
	                    while (low <= high && s.charAt(high) != s.charAt(i)) {
	                        high--;
	                    }
	                    
	                    if (low > high) {
	                        // No other occurrences of s[i] in s[i+1:j]
	                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
	                    } else if (low == high) {
	                        // One other occurrence of s[i]
	                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
	                    } else {
	                        // More than one occurrence of s[i]
	                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
	                    }
	                } else {
	                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
	                }
	                
	                // Ensure non-negative modulo
	                dp[i][j] = (dp[i][j] % MOD + MOD) % MOD;
	            }
	        }
	        
	        return dp[0][n - 1];

	}

}
