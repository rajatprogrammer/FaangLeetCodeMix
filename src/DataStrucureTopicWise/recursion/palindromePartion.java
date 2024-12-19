package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/description/
public class palindromePartion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        exploreAndBacktrack(s, 0, res, new ArrayList<>());
        return res;
    }
    
    private void exploreAndBacktrack(String s, int idx, List<List<String>> res, List<String> buildUp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(buildUp));
        } else {
            for (int i = idx; i < s.length(); i++) {
                String curr = s.substring(idx, i + 1);
                if (isPalindrome(curr)) {
                    buildUp.add(curr);
                    exploreAndBacktrack(s, idx + curr.length(), res, buildUp);
                    buildUp.remove(buildUp.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}
