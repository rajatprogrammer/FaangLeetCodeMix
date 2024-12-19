package DataStrucureTopicWise.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
/*
 * 
Code
Testcase
Test Result
Test Result
159. Longest Substring with At Most Two Distinct Characters
Solved
Medium
Topics
Companies
Given a string s, return the length of the longest 
substring
 that contains at most two distinct characters.

 

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
 * */
public class Longestwithatmost2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ccaabbb";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            // when the slidewindow contains less than 3 characters
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
	

}
