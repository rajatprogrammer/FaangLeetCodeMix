package DataStrucureTopicWise.String;

import java.util.Stack;

// Reverse Substrings Between Each Pair of Parentheses
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
//O(n)
//microsoft
public class ReverseStringInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(ed(et(oc))el)";
		optimizedSolution1(s);
	}
	
	//O(N)
	public  static void optimizedSolution1(String s) {
		Stack<String> st = new Stack<String>();
		StringBuilder ans = new StringBuilder();
		for(char ch : s.toCharArray()) {
			if(ch == '(') {
				st.push(ans.toString());
				ans.setLength(0);
			}else if(ch == ')') {
				ans.reverse();
				ans.insert(0, st.pop());
			}else {
				 ans.append(ch);
			}
		}
		System.out.println(ans.toString());
	}
}
