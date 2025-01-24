package CompanyWiseLeetcodeGoogle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * https://leetcode.com/problems/special-binary-string/description
 * 
 * Special binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.
Every prefix of the binary string has at least as many 1's as 0's.
You are given a special binary string s.

A move consists of choosing two consecutive, non-empty, special substrings of s, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.

Return the lexicographically largest resulting string possible after applying the mentioned operations on the string.
 * 
 * */
public class SpecialBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ar = "11011000" ;
		System.out.println(makeLargestSpecial(ar.toString()));
	}
	
	public static String makeLargestSpecial(String S) {
        if (S.length() == 0) return S;
        int anchor = 0, bal = 0;
        List<String> mountains = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '1' ? 1 : -1;
            if (bal == 0) {
                mountains.add("1" + makeLargestSpecial(S.substring(anchor+1, i)) + "0");
                anchor = i+1;
            }
        }
        Collections.sort(mountains, Collections.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String mtn: mountains)
            ans.append(mtn);
        return ans.toString();
    }

}
