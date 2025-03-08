package InterviewFaang.Recusrsion;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class palindrome_partion2 {
	private Map<String, Integer> memo = new HashMap<>();
	public int minCut(String s) {
        return minCutHelper(s, 0, s.length() - 1);
    }

    private int minCutHelper(String s, int start, int end) {
        // If the substring is already a palindrome or has length 1, no cuts are needed
        if (start >= end || isPalindrome(s, start, end)) {
            return 0;
        }
        
        String key = start + "," + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCuts = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            if (isPalindrome(s, start, i)) {
                int cuts = 1 + minCutHelper(s, i + 1, end);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        
        memo.put(key, minCuts);

        return minCuts;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
    	palindrome_partion2 solution = new palindrome_partion2();
        System.out.println(solution.minCut("aab")); // Output: 1
        System.out.println(solution.minCut("a"));   // Output: 0
        System.out.println(solution.minCut("ab"));  // Output: 1
    }

}
