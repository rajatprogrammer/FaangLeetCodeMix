package DataStrucureTopicWise.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
//https://leetcode.com/problems/distinct-subsequences-ii/submissions/
public class distinctSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabgdba";
		System.out.print(distinctSubseqII(s));
	}
	public static int distinctSubseqII(String S) {
		int M=(int)(Math.pow(10, 9)+7);
		int dp[] = new int[S.length()];
		Arrays.fill(dp, 1);
		for(int i=1;i<S.length();i++) {
			for(int j=0;j<i;j++) {
				if(S.charAt(i)!=S.charAt(j)) {
					dp[i]=(dp[j]+dp[i])%M;	
				}
			}
		}
		int total=0;
		for(int i=0;i<dp.length;i++) {
			total = (total + dp[i])%M;
		}
      return total;  
    }
	
	public static int distinctSubseqIIRecursive(String s) {
	        HashSet<String> resultSet = new HashSet<>();
	        generateSubsequences(s, 0, "", resultSet);
	        return resultSet.size();
	    }

	      private static void generateSubsequences(String s, int index, String current, HashSet<String> resultSet) {
	        if (index == s.length()) {
	            if (!current.isEmpty()) {
	                resultSet.add(current); // Add the subsequence to the set
	            }
	            return;
	        }

	        // Include the current character
	        generateSubsequences(s, index + 1, current + s.charAt(index), resultSet);

	        // Exclude the current character
	        generateSubsequences(s, index + 1, current, resultSet);
	    }
	
	

}
