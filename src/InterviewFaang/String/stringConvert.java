package InterviewFaang.String;

import java.util.Arrays;

/*https://leetcode.com/problems/determine-if-two-strings-are-close/
 * wo strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * */
public class stringConvert {
	  static int N = 26;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "abc";
		String word2 = "bca";
		System .out.print(closeStrings(word1,word2));
	}
	public static boolean closeStrings(String word1, String word2) {
		// count the English letters
        int[] arr1 = new int[N], 
        arr2 = new int[N];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;
		
		// if one has a letter which another one doesn't have, dont exist
        for (int i = 0; i < N; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            if (arr1[i] == 0 || arr2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
