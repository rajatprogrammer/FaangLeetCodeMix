package CompanyWiseLeetcodeGoogle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * You are given a string s representing a list of words. Each letter in the word has one or more options.

If there is one option, the letter is represented as is.
If there is more than one option, then curly braces delimit the options. For example, "{a,b,c}" represents options ["a", "b", "c"].
For example, if s = "a{b,c}", the first character is always 'a', but the second character can be 'b' or 'c'. The original list is ["ab", "ac"].

Return all words that can be formed in this manner, sorted in lexicographical order.

 

Example 1:

Input: s = "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:

Input: s = "abcd"
Output: ["abcd"]
 

Constraints:

1 <= s.length <= 50
s consists of curly brackets '{}', commas ',', and lowercase English letters.
s is guaranteed to be a valid input.
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.
 * */
public class BraceExpension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[] expand(String s) {
        List<String> result = new ArrayList<>();
        helper(0, s, result, new StringBuilder());
        String res[] = result.toArray(new String[result.size()]);
        Arrays.sort(res);
        return res;
    }

    public void helper(int i, String s, List<String> result, StringBuilder temp) {
        if(i>=s.length()) {
            result.add(String.valueOf(temp));
            return;
        }

        if(s.charAt(i)=='{'){
            int end = s.indexOf('}', i);
            String[] options = s.substring(i+1, end).split(",");
            for(String option: options){
                StringBuilder sb = new StringBuilder(temp.append(option));
                helper(end+1, s, result, temp);
                temp = sb.deleteCharAt(sb.length()-1);
            }
        }else{
            temp.append(s.charAt(i)+"");
            helper(i+1, s, result, temp);
        }
    }

}
