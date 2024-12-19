package DataStrucureTopicWise.ARRAY;
//https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
public class MinimumDelre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="aababbab";
		System.out.println(minimumDeletions(s));
	}
	
	public static int minimumDeletions(String s) {
        int n = s.length();
        int countB = 0;  // Count of 'b' characters encountered
        int result = 0;  // Minimum deletions needed

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;  // Increment count of 'b'
            } else {  // c == 'a'
                // We have two choices:
                // 1. Keep this 'a' and delete all previous 'b's (countB)
                // 2. Delete this 'a' (increment result)
                // We choose the option that requires fewer deletions
                result = Math.min(result + 1, countB);
            }
        }

        return result;
    }

}
