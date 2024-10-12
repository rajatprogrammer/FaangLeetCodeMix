package String;
//https://leetcode.com/problems/replace-the-substring-for-balanced-string/
/*You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

Return 0 if the string is already balanced.

 

Example 1:

Input: s = "QWER"
Output: 0
Explanation: s is already balanced.
Example 2:

Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
Example 3:

Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER". 
Example 4:

Input: s = "QQQQ"
Output: 3
Explanation: We can replace the last 3 'Q' to make s = "QWER".
 

Constraints:

1 <= s.length <= 10^5
s.length is a multiple of 4
s contains only 'Q', 'W', 'E' and 'R'.

 * */
public class balanced_string {

	public static void main(String[] args) {
		String s = "QQQQ";
		System.out.print(balancedString(s));
	}
	 public static int balancedString(String s) {
	        int required = s.length() / 4, answer = s.length();
	        int[] arr = new int[4];
	        
	        for (int i = 0; i < s.length(); i++) {
	            arr[getIndex(s.charAt(i))]++;
	        }
	        
	        int l = 0, r = 0;
	        while (r < s.length()) {
	            for (int j = 0; j < 4; j++) {
	                while (r < s.length() && arr[j] > required) {
	                    arr[getIndex(s.charAt(r++))]--;
	                }
	            }
	            
	            if (l < r) {
	                do {
	                    answer = Math.min(answer, r - l);
	                    arr[getIndex(s.charAt(l++))]++;
	                } while (arr[0] <= required && arr[1] <= required && arr[2] <= required && arr[3] <= required && l < r);
	            } else {
	                answer = Math.min(answer, r - l);
	                r++;
	            }
	        }
	        
	        return answer;
	    }
	    
	    private static int getIndex(char cur) {
	        switch (cur) {
	            case 'Q': return 0;
	            case 'W': return 1;
	            case 'E': return 2;
	            case 'R': return 3;
	        }
	        
	        throw new IllegalArgumentException();
	    }
	

}
