package DataStrucureTopicWise.ARRAY;
/*
 * https://leetcode.com/problems/count-good-numbers/
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 

Constraints:

1 <= n <= 1015
 * 
 * 
 * */
public class CountGoodNumber {

	static int MOD = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countGoodDigitStrings(4));
		System.out.println(countGoodNumbers(4));
	}
    
    public static int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // Count of even index positions
        long oddCount = n / 2; // Count of odd index positions

        // Compute (5^evenCount * 4^oddCount) % MOD using fast exponentiation
        return (int) (modularExponentiation(5, evenCount, MOD) * modularExponentiation(4, oddCount, MOD) % MOD);
    }

    private static long modularExponentiation(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // Divide exp by 2
        }
        return result;
    }
    
    //recursive
    
    public static int countGoodDigitStrings(int n) {
        // Memoization array to store intermediate results for each index
        Integer[] memo = new Integer[n];
        return countGoodDigitStringsHelper(0, n, memo);
    }

    private static int countGoodDigitStringsHelper(int index, int n, Integer[] memo) {
        // Base case: if we have reached the end of the string
        if (index == n) {
            return 1; // A valid string of length n has been constructed
        }

        // If we have already calculated this subproblem, return the result
        if (memo[index] != null) {
            return memo[index];
        }

        // Determine the valid digits based on the index
        int validDigitCount = 0;
        if (index % 2 == 0) {
            // Even index: valid digits are even numbers: 0, 2, 4, 6, 8
            validDigitCount = 5;
        } else {
            // Odd index: valid digits are prime numbers: 2, 3, 5, 7
            validDigitCount = 4;
        }

        // Recursively calculate the number of good digit strings from the current index
        int result = validDigitCount * countGoodDigitStringsHelper(index + 1, n, memo) % MOD;

        // Store the result for the current index in the memo array
        memo[index] = result;

        return result;
    }

}
