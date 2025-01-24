package CompanyWiseLeetcodeGoogle;
/*https://leetcode.com/problems/reverse-integer/description/?envType=company&envId=google&favoriteSlug=google-six-months
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.


 * */
public class reverse_integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reverse(int x) {
        int result = 0;     // Good for this type of problem
        int prev = 0;       // Prev is last result to check overflow
        
        while (x != 0) {
            // Breaking off the last digit of the number
            int cur = x % 10;
            x /= 10;
            
            // Adding digit to the reversed number
            result = result * 10 + cur;
            
            // Check for overflow
            if ((result- cur) / 10 != prev) return 0;
            
            // Update prev because we need to check for overflow
            prev = result;
        }
        return result;
    }
	

}
