package CompanyWiseLeetcodeGoogle;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/construct-k-palindrome-strings
 * Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

 

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= 105
 * */
public class KPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int oddCount = 0;
        for (int i = 0; i < chars.length; ) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            if (count % 2 != 0) oddCount++;
        }

        return oddCount <= k;
    }

}
