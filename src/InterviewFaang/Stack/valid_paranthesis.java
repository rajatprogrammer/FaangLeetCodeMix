package Stack;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/
/**
 * 
 * @author rajat
 *Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */
public class valid_paranthesis {

	public static void main(String[] args) {
		String str = "()(()";
		System.out.print(longestValidParentheses(str));

	}
	public static int longestValidParentheses(String name) {
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(-1);
		int count=0;
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i)=='(') {
				stk.push(i);	
			}else {
				stk.pop();
				if(stk.isEmpty()) {
					stk.push(i);
				}else {
					count = Math.max(count, i-stk.peek());
				}
			}
		}
		return count;
		
	}

}
