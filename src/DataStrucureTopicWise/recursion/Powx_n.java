package DataStrucureTopicWise.recursion;
//https://leetcode.com/problems/string-to-integer-atoi/description/
//Olog(n) solution
public class Powx_n {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 10;
		int n=6;
		binaryExp(x, (long) n);
	}
	
	 private static double binaryExp(double x, long n) {
	        if (n == 0) {
	            return 1;
	        }

	        // Handle case where, n < 0.
	        if (n < 0) {
	            n = -1 * n;
	            x = 1.0 / x;
	        }

	        // Perform Binary Exponentiation.
	        double result = 1;
	        while (n != 0) {
	            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
	            if (n % 2 == 1) {
	                result = result * x;
	                n -= 1;
	            }
	            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
	            x = x * x;
	            n = n / 2;
	        }
	        return result;
	    }

}
