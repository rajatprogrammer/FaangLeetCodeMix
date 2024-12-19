package InterviewFaang.Array;
//https://leetcode.com/discuss/interview-question/381157/Google-or-Onsite-or-Min-Transactions

/*Given an int array banks, where banks[i] represents a balance of the i-th bank, and an int target. Find minimum number of transactions to make all balances equal or greater than target.

Example 1:

Input: 
bankName = [A,   B,   C,  D]
banks =    [110, 180, 60, 90], target = 110
Output: 2
Explanation:
bankB gave bankC $50.
bankB gave bankD $20.

2 transactions are needed.
Example 2:

Input: 
bankName =  [A, B, C,  D,  E, F,  G,   H,  I]
banks =     [2, 1, 0, 10, 10, 10, 10, 14, 15], target = 8
Ouput: 6
Explanation:
bankH gave bankA $6;
bankI gave bankB $7;
bankG gave bankC $2;
bankF gave bankC $2;
bankE gave bankC $2;
bankD gave bankC $2;

6 transactions are needed.
    class Solution {
		public int minTrans(int[] banks) {
		   // add your code here
		}
	}
 * */
public class transaction {
	private static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 1, 0, 10, 10, 10, 10, 14, 15};
		int target = 8;
		System.out.print(transaction(arr,target));
	}
    public static int transaction(int[] banks, int k) {
        int[] balance = new int[banks.length];
        for (int i = 0; i < banks.length; i++) {
            balance[i] = banks[i] - k;
        }
        transactionHelper(balance, 0, 0);
        return ans;
    }

    private static void transactionHelper(int[] balance, int index, int count) {
        if (index == balance.length || count >= ans) {
            return;
        }

        if (isBalance(balance)) {
            ans = count;
            return;
        }
        // no need for transaction for this account
        if (balance[index] == 0) {
            transactionHelper(balance, index+1, count);
        }
        for (int i = index+1; i < balance.length; i++) {
            int a = balance[index], b = balance[i];
            if (a * b < 0) { // one is above k and the other one is below, a transaction can be made between index and i
                if (a + b > 0) {
                    balance[index] = a + b;
                    balance[i] = 0;
                    transactionHelper(balance, index, count+1); // balance of account index will not be 0, do not proceed to next account
                } else {
                    balance[index] = 0;
                    balance[i] = a+b;
                    transactionHelper(balance, index+1, count+1); // balance of account index will be 0, proceed to next account
                }
            }
            balance[index] = a;
            balance[i] = b;
        }
    }

    private static boolean isBalance(int[] balance) {
        for (int b : balance) {
            if (b < 0) {
                return false;
            }
        }
        return true;
    }

}
