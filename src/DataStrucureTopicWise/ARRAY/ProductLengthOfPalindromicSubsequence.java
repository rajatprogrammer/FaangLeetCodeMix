package DataStrucureTopicWise.ARRAY;

/*
 * https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/
 * 
 * Input: s = "leetcodecom"
Output: 9
Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
The product of their lengths is: 3 * 3 = 9.
Example 2:

Input: s = "bb"
Output: 1
Explanation: An optimal solution is to choose "b" (the first character) for the 1st subsequence and "b" (the second character) for the 2nd subsequence.
The product of their lengths is: 1 * 1 = 1.
Example 3:

Input: s = "accbcaxxcxx"
Output: 25
Explanation: An optimal solution is to choose "accca" for the 1st subsequence and "xxcxx" for the 2nd subsequence.
The product of their lengths is: 5 * 5 = 25.
 

Constraints:

2 <= s.length <= 12
s consists of lowercase English letters only.

Seen this question in a real interview before?
1/5
 * */
public class ProductLengthOfPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 
    int max = 0;
    public int maxProduct(String s) {
        
        char[] c = s.toCharArray();
        dfs(c, 0, "", "");
        
        return max;
    }
    
    public void dfs(char[] c, int i, String s1, String s2){
        
        if(i >= c.length){
            
            if(isPalin(s1) && isPalin(s2))
                max = Math.max(max, s1.length()*s2.length());
            return;
        }
        
        dfs(c, i+1, s1+c[i], s2);
        dfs(c, i+1, s1, s2+c[i]);
        dfs(c, i+1, s1, s2);
    }
    
     public boolean isPalin(String str){
 
        int i = 0, j = str.length() - 1;
 
        while (i < j) {
 
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
 
        return true;
    }

}
