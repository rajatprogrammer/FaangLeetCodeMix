package CompanyWiseLeetcodeGoogle;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.
Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 

Constraints:


 * 
 * */
public class SplitStringIntoUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();  // Set to store unique substrings
        return backtrack(s, 0, seen);
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return seen.size();
        }
        int maxSplits = 0;
        // Try splitting at each possible point in the string
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (!seen.contains(substring)) {
                seen.add(substring);
                maxSplits = Math.max(maxSplits, backtrack(s, i, seen));
                seen.remove(substring);  // Backtrack
            }
        }
        return maxSplits;
    }

}
