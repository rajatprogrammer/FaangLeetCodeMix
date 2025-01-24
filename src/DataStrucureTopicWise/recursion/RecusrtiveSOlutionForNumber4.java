package DataStrucureTopicWise.recursion;

import java.util.Scanner;

public class RecusrtiveSOlutionForNumber4 {

	private static final int MOD = 1000000007;

    public static int countSubsequencesDivisibleBy4(String number) {
        int n = number.length();
        long count = 0;

        // Iterate through the string
        for (int i = 0; i < n; i++) {
            // Single digit subsequence
            int singleDigit = number.charAt(i) - '0';
            if (singleDigit % 4 == 0) {
                count = (count + 1) % MOD;
            }

            // Two-digit subsequences (if possible)
            if (i > 0) {
                int twoDigits = (number.charAt(i - 1) - '0') * 10 + singleDigit;
                if (twoDigits % 4 == 0) {
                    count = (count + (i)) % MOD; // Add all possible subsequences ending here
                }
            }
        }

        return (int) count;
    }
    
    public static int countHelper(String number, int index, int currentMod) {
        // Base case: If we have processed all characters
        if (index == number.length()) {
            // Check if the current subsequence is divisible by 4
            return currentMod == 0 ? 1 : 0;
        }

        // Current digit
        int digit = number.charAt(index) - '0';

        // Recursive case:
        // 1. Exclude the current character
        int exclude = countHelper(number, index + 1, currentMod);

        // 2. Include the current character
        int newMod = (currentMod * 10 + digit) % 4;
        int include = countHelper(number, index + 1, newMod);

        // Return the sum of both cases modulo MOD
        return (exclude + include) % MOD;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input large number as a string
        System.out.print("Enter the large number string: ");
        String number = scanner.nextLine();

        // Output the result
        System.out.println("Count of subsequences divisible by 4: " + countSubsequencesDivisibleBy4(number));
    }

	
	

}
