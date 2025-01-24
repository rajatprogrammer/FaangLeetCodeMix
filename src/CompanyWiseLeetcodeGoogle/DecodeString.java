package CompanyWiseLeetcodeGoogle;
/*
 * https://leetcode.com/problems/decode-string/description
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 * */
public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a2[c]]";
		System.out.println(decodeString(s));
	}
	
	 /**
    Recursion solution,by maintaining a global index to prevent index from missing during backtracking; 
  **/
  public static String decodeString(String s) {
      Index index = new Index();
      return dfs(s, index);
  }

  private static String dfs(String s, Index index) {
      StringBuilder res = new StringBuilder(); // maintain the decoded string from index.val(at beginning for current stack) -> s.length() - 1
      int num = 0;
      while(index.val < s.length()) {
          char c = s.charAt(index.val);
          if(Character.isDigit(c)) {
              index.val ++;
              num = num * 10 + c - '0';
          } else if(c == '[') { // '[' is the signal for recursive call;
              index.val ++;
              String sub = dfs(s, index);
              for(int i = 0; i < num; i ++) {
                  res.append(sub);
              }
              num = 0;
          } else if(c == ']') {
              index.val ++;
              return res.toString();
          } else {
              res.append(c);
              index.val ++;
          }
      }
      return res.toString();
  }

  static class Index {
      int val;
  }
	

}
