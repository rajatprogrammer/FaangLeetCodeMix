package CompanyWiseLeetcode.sailsforce;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/smallest-substring-with-identical-characters-i/
 * 3398. Smallest Substring With Identical Characters I
Solved
Hard
Topics
Companies
Hint
You are given a binary string s of length n and an integer numOps.

You are allowed to perform the following operation on s at most numOps times:

Select any index i (where 0 <= i < n) and flip s[i]. If s[i] == '1', change s[i] to '0' and vice versa.
You need to minimize the length of the longest 
substring
 of s such that all the characters in the substring are identical.

Return the minimum length after the operations.

Input: s = "000001", numOps = 1

Output: 2

Explanation: 

By changing s[2] to '1', s becomes "001001". The longest substrings with identical characters are s[0..1] and s[3..4].

Example 2:

Input: s = "0000", numOps = 2

Output: 1

Explanation: 

By changing s[0] and s[2] to '1', s becomes "1010".

Example 3:

Input: s = "0101", numOps = 0

Output: 1

 

Constraints:

1 <= n == s.length <= 1000
s consists only of '0' and '1'.
0 <= numOps <= n
 * */
public class SmallestCharacterWIthIdentical1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minLength("000001",1));
	}
	
	public static int minLength(String s, int numOps) {
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == i % 2) temp++;
        }
        if (temp <= numOps || s.length() - temp <= numOps) return 1;
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                arr.add(count);
                count = 1;
            }
        }
        arr.add(count);
        int l = 2;
        int r = s.length();
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i : arr) {
                sum += i / (mid + 1);
            }
            if (sum <= numOps) r = mid;
            else l = mid + 1;
        }
        return l;
    }

}
