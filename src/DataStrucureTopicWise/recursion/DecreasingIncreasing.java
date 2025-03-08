package DataStrucureTopicWise.recursion;

import java.util.HashSet;

//https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
public class DecreasingIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String smallestNumber(String pattern) {
	       int n = pattern.length();
	        StringBuilder result = new StringBuilder();
	        HashSet<Integer> usedDigits = new HashSet<>();
	        
	        // Start recursion from the first digit
	        if (solve(pattern, 0, n + 1, usedDigits, result)) {
	            return result.toString();
	        }
	        return "";
	    }

	   private boolean solve(String pattern, int index, int n, HashSet<Integer> usedDigits, StringBuilder result) {
	        // Base case: When we have constructed n digits
	        if (index == n) {
	            return true;
	        }

	        // Try numbers from 1 to 9 (smallest first for lexicographically smallest result)
	        for (int num = 1; num <= 9; num++) {
	            if (!usedDigits.contains(num)) {
	                // Ensure the number follows the pattern constraints
	                if (index > 0) {
	                    char prevChar = pattern.charAt(index - 1);
	                    int prevNum = result.charAt(index - 1) - '0';

	                    if ((prevChar == 'I' && prevNum >= num) || (prevChar == 'D' && prevNum <= num)) {
	                        continue; // Skip if constraints are not met
	                    }
	                }

	                // Mark the number as used
	                usedDigits.add(num);
	                result.append(num);

	                // Recurse to place the next number
	                if (solve(pattern, index + 1, n, usedDigits, result)) {
	                    return true;
	                }

	                // Backtrack
	                usedDigits.remove(num);
	                result.deleteCharAt(result.length() - 1);
	            }
	        }
	        return false; // If no valid number is found
	    }
}
