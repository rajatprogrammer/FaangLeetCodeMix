package DataStrucureTopicWise.SlidingWindow;

import java.util.Arrays;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class substring_max {

	public static void main(String[] args) {
		String s = "ababacb";
		int k=2;
		System.out.println(longestSubstring(s,k));

	}
	   public static int longestSubstring(String s, int k) {
	        if (s == null || s.length() == 0) return 0;
	        char[] chars = new char[26];
	        // record the frequency of each character
	        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
	        boolean flag = true;
	        for (int i = 0; i < chars.length; i += 1) {
	            if (chars[i] < k && chars[i] > 0) flag = false;
	        }
	        // return the length of string if this string is a valid string
	        if (flag == true) return s.length();
	        int result = 0;
	        int start = 0, cur = 0;
	        // otherwise we use all the infrequent elements as splits
	        while (cur < s.length()) {
	            if (chars[s.charAt(cur) - 'a'] < k) {
	                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
	                start = cur + 1;
	            }
	            cur++;
	        }
	        result = Math.max(result, longestSubstring(s.substring(start), k));
	        return result;
	    }
	}

