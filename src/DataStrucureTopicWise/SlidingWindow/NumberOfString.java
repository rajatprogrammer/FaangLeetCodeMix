package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class NumberOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfSubstrings("abcabc"));
	}
	public  static int numberOfSubstrings(String s) {
        int aTot = 0, bTot = 0, cTot = 0; // to track the count of 'a', 'b', 'c'
        int res = 0;
        int i = 0, j = 0;
    
        while (j < s.length()) {
            // Expand the window by including s[j]
            if (s.charAt(j) == 'a') aTot++;
            else if (s.charAt(j) == 'b') bTot++;
            else if (s.charAt(j) == 'c') cTot++;
    
            // Check if the current window has at least one 'a', 'b', and 'c'
            while (aTot > 0 && bTot > 0 && cTot > 0) {
                // If valid, count all substrings starting from i to the end
                res += s.length() - j;
    
                // Move the start of the window forward to reduce the window size
                if (s.charAt(i) == 'a') aTot--;
                else if (s.charAt(i) == 'b') bTot--;
                else if (s.charAt(i) == 'c') cTot--;
                
                i++; // Move the start pointer
            }
            
            j++; // Move the end pointer
        }
        return res;
    }

}
