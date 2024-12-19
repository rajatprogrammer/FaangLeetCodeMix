package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/generate-parentheses/description/
//https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/
public class Generate_paranthesis {
	
	public static void main() {
		System.out.println(generateParenthesis(4).toArray());
	}
	
	
	public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
