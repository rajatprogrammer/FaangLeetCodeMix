package InterviewFaang.Recusrsion;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/palindrome-partitioning/
//amazon
public class palindrome_partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		List<List<String>> res = new ArrayList<List<String>>();
		recurive(s,0,res,new ArrayList<String>());
	}
	
	public static void recurive(String s,int idx,List<List<String>> res, List<String> buildUp) {
		if(idx>=s.length()) {
			res.add(new ArrayList<String>(buildUp));
		}
		for(int i=idx;i<s.length();i++) {
			String cur = s.substring(idx,i+1);
			if(isPalindrome(cur)) {
				buildUp.add(cur);
				recurive(cur,idx+1,res,buildUp);
				buildUp.remove(buildUp.size() - 1);
			}
		}
	}
	 private static boolean isPalindrome(String s) {
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
