package DataStrucureTopicWise.DP;
//https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/?ref=rp
public class subsequenceSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "LLBLLACLLDBLLDLLCDLL";
		String y = "BACDBDCD";
		System.out.print(subsequenceRecursive(y,x,0,0));
	}
	
	static int subsequenceRecursive(String S,String N,int s,int n) {
		if(n>=N.length()-1) {
			return 1;
		}
		if(s>=S.length()-1) {
			return 1;
		}
		 if(S.charAt(s)==N.charAt(n)) {
			return 1 + subsequenceRecursive(S,N,s+1,n+1)+subsequenceRecursive(S,N,s+1,n); 
		}else {
			return subsequenceRecursive(S,N,s+1,n);
		}
	}
	
	public int longestSubsequenceSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        int maxLen = 0;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]); // Update maximum length
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return maxLen;
    }

}
