package CompanyWiseLeetcodeGoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * https://leetcode.com/problems/word-subsets/description
Companies
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
 * */
public class wordSubsted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharFreq = new int[26];
        int[] tempCharFreq = new int[26];

        for (String word : words2) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
            }
        }

        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (maxCharFreq[i] > tempCharFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }

}
