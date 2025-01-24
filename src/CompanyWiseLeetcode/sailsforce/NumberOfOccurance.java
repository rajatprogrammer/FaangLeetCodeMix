package CompanyWiseLeetcode.sailsforce;

import java.util.HashMap;
import java.util.Map;

/*
 *  Maximum Number of Occurrences of a Substring
 *  Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 occurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 * */
public class NumberOfOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxFreq = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<String, Integer> substringToCount = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand window
            char cr = s.charAt(right);
            window.put(cr, window.getOrDefault(cr, 0) + 1);

            // Fixed size sliding window
            if (right - left + 1 == minSize) {
                // Check if the window has at most 'maxLetters' distinct characters
                if (window.size() <= maxLetters) {
                    String sub = s.substring(left, right + 1);
                    substringToCount.put(sub, substringToCount.getOrDefault(sub, 0) + 1);
                    maxFreq = Math.max(maxFreq, substringToCount.get(sub));
                }

                // Shrink window
                char cl = s.charAt(left);
                window.put(cl, window.get(cl) - 1);
                if (window.get(cl) == 0)
                    window.remove(cl);
                left++;
            }
        }

        return maxFreq;
    }

}
