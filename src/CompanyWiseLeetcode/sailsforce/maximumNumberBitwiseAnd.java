package CompanyWiseLeetcode.sailsforce;

/*
 * https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero
 * Given an integer n, return the maximum integer x such that x <= n, and the bitwise AND of all the numbers in the range [x, n] is 0.
 

Example 1:

Input: n = 7

Output: 3

Explanation:

The bitwise AND of [6, 7] is 6.
The bitwise AND of [5, 6, 7] is 4.
The bitwise AND of [4, 5, 6, 7] is 4.
The bitwise AND of [3, 4, 5, 6, 7] is 0.

Example 2:

Input: n = 9

Output: 7

Explanation:

The bitwise AND of [7, 8, 9] is 0.

Example 3:

Input: n = 17

Output: 15

Explanation:

The bitwise AND of [15, 16, 17] is 0.

 

Constraints:

1 <= n <= 1015
 * 
 * */
public class maximumNumberBitwiseAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long maxNumber(long n) {
        long num=1;

        //finding MSB
        while((num<<1)<=n) {
            num<<=1;
        }
        //substract 1 from MSB
        return num-1;
    }

}
