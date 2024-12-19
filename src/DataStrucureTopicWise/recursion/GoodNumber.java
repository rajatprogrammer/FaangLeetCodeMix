package DataStrucureTopicWise.recursion;
//https://leetcode.com/problems/count-good-numbers/description/
import java.util.HashMap;

public class GoodNumber {
    static int MOD = 1000000007;
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 50; // Example length, you can change it
        System.out.println(helper(n, 0)); // Output the total number of good digit strings
        countGoodNumbers(5);
    }

    public static int helper(int n, int index) {
        // Base case: when no more digits to add, return 1 (valid string found)
        if (n == 0) {
            return 1;
        }

        // Create a memoization key based on (n, index)
        String key = n + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key); // If already computed, return stored result
        }

        int totalWays = 0;
        
        // Handle even indices (0-based)
        if (index % 2 == 0) {
            // Even digits for even indices: 0, 2, 4, 6, 8
            for (int i : new int[]{0, 2, 4, 6, 8}) {
                totalWays = (totalWays + helper(n - 1, index + 1)) % MOD;
            }
        } else { // Handle odd indices (0-based)
            // Prime digits for odd indices: 2, 3, 5, 7
            for (int i : new int[]{2, 3, 5, 7}) {
                totalWays = (totalWays + helper(n - 1, index + 1)) % MOD;
            }
        }

        // Memoize the result for the current (n, index)
        memo.put(key, totalWays);
        return totalWays;
    }
    
    // more optimized way
    //final
    public static int countGoodNumbers(long n) {
        
        // Calculate the number of even and odd positions in the digit string
        long odd = n/2;
        long even = (n+1)/2;
        
        // Calculate the total number of good digit strings
        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }
    
    public static long pow(long x, long n){
        
        // Base case for the recursion
        if(n==0) 
            return 1;
        
        // Recursively calculate x^(n/2)
        long temp = pow(x,n/2);
        
        // If n is even, return (x^(n/2))^2
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp)% MOD;
        }
    }
}