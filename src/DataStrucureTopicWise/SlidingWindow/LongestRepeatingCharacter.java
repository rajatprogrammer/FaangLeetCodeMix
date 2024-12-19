package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("ABAB",2));
	}
	 public static int characterReplacement(String s, int k) {
	        int ans = 0;
	        int n = s.length();
	        for (char c = 'A'; c <= 'Z'; c++) {
	            int i = 0, j = 0, replaced = 0;
	            while (j < n) {
	                if (s.charAt(j) == c) {
	                    j++;
	                } else if (replaced < k) {
	                    j++;
	                    replaced++;
	                } else if (s.charAt(i) == c) {
	                    i++;
	                } else {
	                    i++;
	                    replaced--;
	                }
	                ans = Math.max(ans, j - i);
	            }
	        }
	        return ans;
	    }
}
