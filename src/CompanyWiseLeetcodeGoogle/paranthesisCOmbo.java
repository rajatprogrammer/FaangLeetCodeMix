package CompanyWiseLeetcodeGoogle;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-case-permutation/description/
 * 784. Letter Case Permutation
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 * */
public class paranthesisCOmbo {
	
	 List<String> ans = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "a1b2";
		paranthesisCOmbo ob1  = new paranthesisCOmbo();
		System.out.println(ob1.letterCasePermutation(x));
	}
	
	public List<String> letterCasePermutation(String s) {
        generate(s.toCharArray(), 0);
        return ans;
    }
	
	 public void generate(char[] arr, int idx) {
	        if (idx == arr.length) {
	            ans.add(new String(arr));
	            return;
	        }

	        if (Character.isDigit(arr[idx])) {
	            generate(arr, idx + 1);
	            return;
	        }

	        arr[idx] = Character.toLowerCase(arr[idx]);
	        generate(arr, idx + 1);

	        arr[idx] = Character.toUpperCase(arr[idx]);
	        generate(arr, idx + 1);
	    }
	
	

}
