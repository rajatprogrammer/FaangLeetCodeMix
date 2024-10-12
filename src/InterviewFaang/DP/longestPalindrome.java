package DP;
//amazon,google
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "forgeeksskeegfor";
		System.out.print(longestPalindromeDp(str));
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
}
