package DataStrucureTopicWise.STACK;


/*
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
 * Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
 * 
 * 
 * */
public class minimumBracketAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int minAddToMakeValid(String s) {
	        int openBrackets = 0;
	        int minAddsRequired = 0;

	        for (char c : s.toCharArray()) {
	            if (c == '(') {
	                openBrackets++;
	            } else {
	                // If an open bracket exists, match it with the closing one
	                // If not, we need to add an open bracket.
	                if (openBrackets > 0) {
	                    openBrackets--;
	                } else {
	                    minAddsRequired++;
	                }
	            }
	        }

	        // Add the remaining open brackets as closing brackets would be required.
	        return minAddsRequired + openBrackets;
	    }

}
