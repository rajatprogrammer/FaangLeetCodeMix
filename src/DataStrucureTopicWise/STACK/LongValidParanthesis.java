package DataStrucureTopicWise.STACK;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/submissions/437545445/
public class LongValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestValidParentheses(String name) {
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
