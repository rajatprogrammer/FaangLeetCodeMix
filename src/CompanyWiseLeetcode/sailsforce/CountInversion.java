package CompanyWiseLeetcode.sailsforce;

import java.util.Collections;
import java.util.HashMap;

/*
 *https://leetcode.com/problems/count-the-number-of-inversions
 *You are given an integer n and a 2D array requirements, where requirements[i] = [endi, cnti] represents the end index and the inversion count of each requirement.

A pair of indices (i, j) from an integer array nums is called an inversion if:

i < j and nums[i] > nums[j]
Return the number of 
permutations
 perm of [0, 1, 2, ..., n - 1] such that for all requirements[i], perm[0..endi] has exactly cnti inversions.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: n = 3, requirements = [[2,2],[0,0]]

Output: 2

Explanation:

The two permutations are:

[2, 0, 1]
Prefix [2, 0, 1] has inversions (0, 1) and (0, 2).
Prefix [2] has 0 inversions.
[1, 2, 0]
Prefix [1, 2, 0] has inversions (0, 2) and (1, 2).
Prefix [1] has 0 inversions.
Example 2:

Input: n = 3, requirements = [[2,2],[1,1],[0,0]]

Output: 1

Explanation:

The only satisfying permutation is [2, 0, 1]:

Prefix [2, 0, 1] has inversions (0, 1) and (0, 2).
Prefix [2, 0] has an inversion (0, 1).
Prefix [2] has 0 inversions.
Example 3:

Input: n = 2, requirements = [[0,0],[1,0]]

Output: 1

Explanation:

The only satisfying permutation is [0, 1]:

Prefix [0] has 0 inversions.
Prefix [0, 1] has an inversion (0, 1).
 

Constraints:

2 <= n <= 300
1 <= requirements.length <= n
requirements[i] = [endi, cnti]
0 <= endi <= n - 1
0 <= cnti <= 400
The input is generated such that there is at least one i such that endi == n - 1.
The input is generated such that all endi are unique.
 * 
 * 
 * */
public class CountInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static int MOD = 1000000007;
	    public int numberOfPermutations(int n, int[][] requirements) {
	    	HashMap<Integer, Integer> reqMap = new HashMap<Integer, Integer>();
	        for (int[] r: requirements) reqMap.put(r[0], r[1]);
	        int maxInv = Collections.max(reqMap.values());
	        
	        int[] dp = new int[maxInv+1];
	        // zero inversion cnt == ascending order
	        dp[0] = 1;

	        // given endi will contain n-1
	        for (int endi = 0; endi <= n-1; endi++) {
	            int[] new_dp = new int[maxInv+1];

	            if (reqMap.containsKey(endi)) {
	                int cnti = reqMap.get(endi);
	                for (int i = 0; i <= Math.min(endi, cnti); i++)
	                    new_dp[cnti] = (new_dp[cnti] + dp[cnti-i]) % MOD;
	                // rest of new_dp = 0 because exactly cnti inversions at endi
	            }
	            else {
	                /**
	                    new_dp[j] = dp[j] + dp[j-1] + .... + dp[j-endi)]
	                    new_dp[j-1] = dp[j-1] + dp[j-2] + ....dp[j-endi] + dp[j-1-endi]
	                    new_dp[j] = dp[j] + new_dp[j-1] - dp[j-1-endi]

	                    In the case endi > j; new_dp[j] = dp[j] + new_dp[j-1]
	                 */
	                for (int j = 0; j <= maxInv; j++) {
	                    new_dp[j] = dp[j];
	                    if (j-1 >= 0) new_dp[j] = (new_dp[j] + new_dp[j-1]) % MOD;
	                    if (j-1-endi >= 0) new_dp[j] = (new_dp[j] - dp[j-1-endi] + MOD) % MOD;
	                }
	            }
	            dp = new_dp;
	        }

	        int res = 0;
	        for (int v: dp) res = (res + v) % MOD;  
	        return res;
	    }

}
