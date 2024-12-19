package InterviewFaang.Stack;

import java.util.HashMap;
import java.util.Stack;
//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//https://leetcode.com/problems/remove-duplicate-letters/
/*Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 


 * */
public class smallestSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bcabc";
		System.out.print(smallestSubsequence(s));
	}
	public static String smallestSubsequence(String s) {
	      HashMap<Character , Integer> map = new HashMap<>();
	        for(int i=0 ; i<s.length() ; i++){
	          char c = s.charAt(i);
	          map.put(c , map.getOrDefault(c , 0)+1);
	        }
	        Stack<Character> st = new Stack<>();
	        boolean visited[] = new boolean[26];
	        for(int i=0 ; i<s.length() ; i++){
	          char c = s.charAt(i);
	          if(visited[c - 'a']){
	            map.put(c , map.get(c) - 1);
	            continue;
	          }
	          while(st.size()!=0 && (st.peek() - 'a') >= (c - 'a') && map.get(st.peek()) != 0 ){
	            visited[st.peek() - 'a'] = false;
	            st.pop();
	          }
	          st.push(c);
	          visited[c - 'a'] = true;
	          map.put(c , map.get(c) - 1);
	          
	        }
	       StringBuilder sb = new StringBuilder();
	      while(st.size()!=0){
	        sb.append(st.pop());
	      }
	      sb = sb.reverse();
	      return sb.toString(); 
	}

}
