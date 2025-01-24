package CompanyWiseLeetcodeGoogle;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * 1639. Number of Ways to Form a Target String Given a Dictionary
Hard
Topics
Companies
Hint
You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.
 * */
public class RecusiveWordFOundInDictonary {

	private int MOD = (int) 1e9+7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numWays(String[] words, String target) {
        if(target.length() > words[0].length()){
            return 0;
        }

        long[][] dp = new long[target.length()][words[0].length()];

        for(long[] it : dp){
            Arrays.fill(it,-1);
        }

        return (int) helper(words, target, 0, 0, dp) % MOD;
    }

    private long helper(String[] words, String target, int i, int j, long[][] dp){
        if(i == target.length()){
            return 1;
        }
        if(j == words[0].length()){
            return 0;
        }

        int remTarget = target.length() - i;
        int remWord = words[0].length() - j;

        if(remTarget > remWord){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        long val = helper(words, target, i, j+1, dp);

        for(int k = 0;k < words.length;k++){
            if(words[k].charAt(j) == target.charAt(i)){
                val += helper(words, target, i+1, j+1, dp);
            }
        }

        return dp[i][j] = (val % MOD);
    }
	
	

}
