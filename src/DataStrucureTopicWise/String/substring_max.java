package DataStrucureTopicWise.String;

import java.util.Arrays;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class substring_max {

	public static void main(String[] args) {
		String s = "ababacb";
		int k=2;
		System.out.println(longestSubstring(s,k));

	}
	
	 public int longestSubstring1(String s, int k) {
	        int len = 0;
	        int[] count = new int[26];
	        for (int i = 1; i <= 26; i++) {
	            Arrays.fill(count, 0);

	            int start = 0, end = 0;
	            int unique = 0;
	            while (end < s.length()) {
	                boolean flag = true;
	                if (count[s.charAt(end++) - 'a']++ == 0)
	                    unique++;

	                while (unique > i) {
	                    if (count[s.charAt(start++) - 'a']-- == 1)
	                        unique--;
	                }

	                for (int j = 0; j < 26; j++) {
	                    if (count[j] > 0 && count[j] < k)
	                        flag = false;
	                }
	                if (flag) {
	                    len = Math.max(len, end - start);
	                }
	            }
	        }
	        return len;
	    }
	    public static int longestSubstring(String s, int k) {
	        char[] str = s.toCharArray();
	        int[] countMap = new int[26];
	        int maxUnique = getMaxUniqueLetters(s);
	        int result = 0;
	        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
	            // reset countMap
	            Arrays.fill(countMap, 0);
	            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
	            while (windowEnd < str.length) {
	                // expand the sliding window
	                if (unique <= currUnique) {
	                    idx = str[windowEnd] - 'a';
	                    if (countMap[idx] == 0) unique++;
	                    countMap[idx]++;
	                    if (countMap[idx] == k) countAtLeastK++;
	                    windowEnd++;
	                }
	                // shrink the sliding window
	                else {
	                    idx = str[windowStart] - 'a';
	                    if (countMap[idx] == k) countAtLeastK--;
	                    countMap[idx]--;
	                    if (countMap[idx] == 0) unique--;
	                    windowStart++;
	                }
	                if (unique == currUnique && unique == countAtLeastK)
	                    result = Math.max(windowEnd - windowStart, result);
	            }
	        }

	        return result;
	    }

	    // get the maximum number of unique letters in the string s
	    static int getMaxUniqueLetters(String s) {
	        boolean map[] = new boolean[26];
	        int maxUnique = 0;
	        for (int i = 0; i < s.length(); i++) {
	            if (!map[s.charAt(i) - 'a']) {
	                maxUnique++;
	                map[s.charAt(i) - 'a'] = true;
	            }
	        }
	        return maxUnique;
	    }

}
