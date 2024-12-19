package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSUbstringWihoutRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
	 public static int lengthOfLongestSubstring(String s) {
		 int[] chars = new int[128];

	        int left = 0;
	        int right = 0;

	        int res = 0;
	        while (right < s.length()) {
	            char r = s.charAt(right);
	            chars[r]++;

	            while (chars[r] > 1) {
	                char l = s.charAt(left);
	                chars[l]--;
	                left++;
	            }

	            res = Math.max(res, right - left + 1);

	            right++;
	        }
	        return res;
	    }

}
