package DataStrucureTopicWise.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * input string = "applepenapple"
 * worddict = [{"apple","pen"}];
 * output = true;
 * the above evry substring is break to dictonary
 * 
 * */
public class WordBreakList {

	 public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordSet = new HashSet<>(wordDict);
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true;
	        
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j < i; j++) {
	                if (dp[j] && wordSet.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return dp[s.length()];
	    }

	    public static void main(String[] args) {
	        String s = "applepenapple";
	        List<String> wordDict = Arrays.asList("apple", "apple");
	        
	        System.out.println("Can the string be segmented? " + wordBreak(s, wordDict));
	    }

}
