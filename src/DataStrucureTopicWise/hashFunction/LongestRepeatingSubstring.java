package DataStrucureTopicWise.hashFunction;
/*ven a string s, return the length of the longest repeating substrings. If no repeating substring exists, return 0.

 

Example 1:

Input: s = "abcd"
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: s = "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
Example 3:

Input: s = "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
50.3K
Submissions
80.5K
Acceptance Rate
62.5
 * */
import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {

    public String longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        String longestSubstring = ""; // To store the longest repeating substring

        // Binary search for the length of the longest repeating substring
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String repeatingSubstring = getRepeatingSubstringOfLength(s, mid);

            if (repeatingSubstring != null) {
                longestSubstring = repeatingSubstring; // Update if we found a repeating substring
                left = mid + 1; // Try for longer length
            } else {
                right = mid - 1; // Try shorter length
            }
        }

        return longestSubstring;
    }

    private String getRepeatingSubstringOfLength(String s, int L) {
        int n = s.length();
        long modulus = (long) Math.pow(2, 32); // Large prime modulus for Rabin-Karp
        long hash = 0;
        long base = 31;  // base for rolling hash
        long baseL = 1;  // base^L

        // Compute base^L for use in rolling hash
        for (int i = 0; i < L; i++) {
            baseL = (baseL * base) % modulus;
        }

        // HashSet to store seen hash values of substrings
        Set<Long> seen = new HashSet<>();

        // Compute the hash of the first substring of length L
        for (int i = 0; i < L; i++) {
            hash = (hash * base + s.charAt(i)) % modulus;
        }
        seen.add(hash);

        // Use rolling hash to compute the hash of subsequent substrings of length L
        for (int i = L; i < n; i++) {
            // Remove leading character and add trailing character
            hash = (hash * base + s.charAt(i) - s.charAt(i - L) * baseL % modulus + modulus) % modulus;

            // If hash already exists, we found a repeating substring
            if (seen.contains(hash)) {
                return s.substring(i - L + 1, i + 1); // Return the repeating substring
            }
            seen.add(hash);
        }

        return null; // No repeating substring of length L found
    }

    public static void main(String[] args) {
        LongestRepeatingSubstring solution = new LongestRepeatingSubstring();

        String s1 = "abcd";
        String s2 = "abbaba";
        String s3 = "aabcaabdaab";

        System.out.println("Longest repeating substring in \"" + s1 + "\": " + solution.longestRepeatingSubstring(s1)); // Output: ""
        System.out.println("Longest repeating substring in \"" + s2 + "\": " + solution.longestRepeatingSubstring(s2)); // Output: "ab" or "ba"
        System.out.println("Longest repeating substring in \"" + s3 + "\": " + solution.longestRepeatingSubstring(s3)); // Output: "aab"
    }
}
