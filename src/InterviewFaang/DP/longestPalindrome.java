package InterviewFaang.DP;
//amazon,google
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "forgeeksskeegfor";
		System.out.println(longestPalindromeDp(str));
		System.out.println(longestPalindrome("babad"));
	}
	 public static String longestPalindromeDp(String s) {
		 	int n = s.length();
		 	 int end=0;
		 	 int start=0;
	        boolean dp[][] = new boolean[n][n];
	        for(int i=0;i<n;i++) {
	        	 for(int j=0;j+i<n;j++) {
	        		 dp[j][j+i]= (s.charAt(j)==s.charAt(j+i)) && (i<2||dp[j+1][j+i-1]);
	        		 if(dp[j][j+i])
	                 {
	                     start = j;
	                     end = j+i;
	                 }
	        	 }
	        }
	        return s.substring(start,end+1);
	      }
	 
	 public static String longestPalindrome(String s) {
	        if (s == null || s.length() <= 1) {
	            return s;
	        }

	        int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        int start = 0;  // Start index of the longest palindrome found
	        int maxLength = 1;  // Length of the longest palindrome found
	        
	        // All substrings of length 1 are palindromes
	        for (int i = 0; i < n; i++) {
	            dp[i][i] = true;
	        }
	        
	        // Check for substrings of length 2 and greater
	        for (int len = 2; len <= n; len++) {
	            for (int i = 0; i < n - len + 1; i++) {
	                int j = i + len - 1;
	                if (s.charAt(i) == s.charAt(j)) {
	                    if (len == 2 || dp[i + 1][j - 1]) {
	                        dp[i][j] = true;
	                        if (len > maxLength) {
	                            maxLength = len;
	                            start = i;
	                        }
	                    }
	                }
	            }
	        }
	        
	        // Return the longest palindromic substring
	        return s.substring(start, start + maxLength);
	    }
	 
	 public static String longestPalindromeRecursive(String s) {
	        if (s == null || s.length() <= 1) {
	            return s;
	        }
	        
	        String longest = "";
	        for (int i = 0; i < s.length(); i++) {
	            // Odd length palindromes (centered at i)
	            String palindrome1 = expandAroundCenter(s, i, i);
	            // Even length palindromes (centered between i and i+1)
	            String palindrome2 = expandAroundCenter(s, i, i + 1);
	            
	            // Update the longest palindrome found
	            if (palindrome1.length() > longest.length()) {
	                longest = palindrome1;
	            }
	            if (palindrome2.length() > longest.length()) {
	                longest = palindrome2;
	            }
	        }
	        return longest;
	    }
	 
	 private static String expandAroundCenter(String s, int left, int right) {
	        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	            left--;
	            right++;
	        }
	        return s.substring(left + 1, right);
	    }
}
