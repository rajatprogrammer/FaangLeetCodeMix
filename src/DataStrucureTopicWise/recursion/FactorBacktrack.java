package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Numbers can be regarded as the product of their factors.

For example, 8 = 2 x 2 x 2 = 2 x 4.
Given an integer n, return all possible combinations of its factors. You may return the answer in any order.

Note that the factors should be in the range [2, n - 1].
Example 1:

Input: n = 1
Output: []
Example 2:

Input: n = 12
Output: [[2,6],[3,4],[2,2,3]]
Example 3:

Input: n = 37
Output: []
 * 
 * */
public class FactorBacktrack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFactors(12);
	}
	
	private static void backtracking(final LinkedList<Integer> factors, final List<List<Integer>> ans) {
        // Got a solution.
        if (factors.size() > 1) {
            ans.add(new ArrayList(factors));
        }
        
        final int lastFactor = factors.removeLast();
        for (int i = factors.isEmpty() ? 2 : factors.peekLast(); i <=  lastFactor / i; ++i) {
            if (lastFactor % i == 0) {
                // Add i and lastFactor / i.
                factors.add(i);
                factors.add(lastFactor / i);
                backtracking(factors, ans);
                // Remove the last 2 elements in factors to restore it after the recursion returns.
                factors.removeLast();
                factors.removeLast();
            }
        }
        // Add lastFactor back to factors to restore it.
        factors.add(lastFactor);
    }

    public static List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> ans = new LinkedList<>();
        backtracking(new LinkedList<>(Arrays.asList(n)), ans);
        return ans;
    }

}
