package DataStrucureTopicWise.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-break/description/
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
       int n = s.length();
       Set<String> words = new HashSet<>(wordDict);
       boolean[] dp = new boolean[n + 1];
       dp[0] = true;

       for (int i = 1; i <= n; i++) {
           for (int j = 0; j < i; j++) {
               if (dp[j] && words.contains(s.substring(j, i))) {
                   dp[i] = true;
                   break;
               }
           }
       }
       return dp[n];
   }
	
	public boolean wordBreakQueue(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }

}
