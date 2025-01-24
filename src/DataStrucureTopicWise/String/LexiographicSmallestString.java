package DataStrucureTopicWise.String;

/*
 * 
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation
 * Given a string s consisting of lowercase English letters. Perform the following operation:

lexicographically smallest
 string after performing the operation.

Example 1:

Input: s = "cbabc"

Output: "baabc"

Explanation:

Perform the operation on the substring starting at index 0, and ending at index 1 inclusive.

Example 2:

Input: s = "aa"

Output: "az"

Explanation:

Perform the operation on the last letter.

Example 3:

Input: s = "acbbc"

Output: "abaab"

Explanation:

Perform the operation on the substring starting at index 1, and ending at index 4 inclusive.

Example 4:

Input: s = "leetcode"

Output: "kddsbncd"

Explanation:

Perform the operation on the entire string.

 

Constraints:

1 <= s.length <= 3 * 105
s consists of lowercase English letters
 * 
 * */
public class LexiographicSmallestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbabc";
		System.out.println(smallestString(s));
	}
	
	public static String smallestString(String s) {
        char ch[] = s.toCharArray();
        int i=0;
        if(ch[0]=='a'){
            while(i<ch.length && ch[i]=='a') i++;
            if(i==ch.length){
                ch[i-1] = 'z';
                return String.valueOf(ch);
            }
        }
        if(ch[i]!='a'){
            while(i<ch.length && ch[i]!='a'){
                ch[i] = (char)(ch[i]-1);
                i++;
            }
        }
        return String.valueOf(ch);
    }

}
