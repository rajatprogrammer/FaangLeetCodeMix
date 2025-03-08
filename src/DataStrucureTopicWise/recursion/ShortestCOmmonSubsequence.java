package DataStrucureTopicWise.recursion;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/shortest-common-supersequence/
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 * */
public class ShortestCOmmonSubsequence {

	 public static String shortestCommonSupersequence(String str1, String str2) {
	        Map<String, String> memo = new HashMap<>();
	        return scsRecursive(str1, str2, 0, 0, memo);
	    }

	    private static String scsRecursive(String str1, String str2, int i, int j, Map<String, String> memo) {
	        String key = i + "," + j;
	        if (memo.containsKey(key)) return memo.get(key);

	        // Base cases
	        if (i == str1.length()) return str2.substring(j);
	        if (j == str2.length()) return str1.substring(i);
	        
	        // If characters match, include and move forward
	        if (str1.charAt(i) == str2.charAt(j)) {
	            String result = str1.charAt(i) + scsRecursive(str1, str2, i + 1, j + 1, memo);
	            memo.put(key, result);
	            return result;
	        }
	        
	        // Otherwise, take the minimum length choice
	        String option1 = str1.charAt(i) + scsRecursive(str1, str2, i + 1, j, memo);
	        String option2 = str2.charAt(j) + scsRecursive(str1, str2, i, j + 1, memo);
	        
	        String result = option1.length() < option2.length() ? option1 : option2;
	        memo.put(key, result);
	        return result;
	    }

	    public static void main(String[] args) {
	        System.out.println(shortestCommonSupersequence("abac", "cab")); // Output: "cabac"
	        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa")); // Output: "aaaaaaaa"
	    }

}
