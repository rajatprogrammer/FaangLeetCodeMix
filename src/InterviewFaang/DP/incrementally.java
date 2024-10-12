package DP;

//https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/
//Expedia
/**
 * Count the number of ways to divide N in k groups incrementally Last Updated:
 * 10-09-2020 Given two integers N and K, the task is to count the number of
 * ways to divide N into K groups of positive integers such that their sum is N
 * and the number of elements in groups follows a non-decreasing order (i.e
 * group[i] <= group[i+1]). Examples:
 * 
 * 
 * Input: N = 8, K = 4 Output: 5 Explanation: Their are 5 groups such that their
 * sum is 8 and the number of positive integers in each group is 4. [1, 1, 1,
 * 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2] Input: N = 24, K =
 * 5 Output: 164 Explanation: There are 164 such groups such that their sum is
 * 24 and number of positive integers in each group is 5
 * 
 * @author rajat
 *
 */
public class incrementally {
	static int dp[][][] = new int[500][500][500];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 24, k = 5;
		for (int i = 0; i < 500; i++) 
		{
			for (int j = 0; j < 500; j++)
			{
				for (int l = 0; l < 500; l++)
					dp[i][j][l] = -1;
			}
		}
		System.out.println(countWaystoDivide(n, k));
		System.out.println(calculateDp(0, 1, n, k));

	}

	static int countWaystoDivide(int n, int k) {
		return calculateHelper(0, 1, n, k);
	}

	private static int calculateHelper(int pos, int prev, int n, int k) {
		if (pos == k) {
			if (n == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if (n == 0) {
			return 0;
		}
		int total = 0;
		for (int i = prev; i <= n; i++) {
			total = total + calculateHelper(pos + 1, i, n - i, k);
		}
		return total;
	}

	static int calculateDp(int pos, int prev, int left, int k) {
		// Base Case
		if (pos == k) {
			if (left == 0)
				return 1;
			else
				return 0;
		}

	// if N is divides completely 
	// into less than k groups
		if (left == 0)
			return 0;

	// If the subproblem has been
	// solved, use the value
		if (dp[pos][prev][left] != -1)
			return dp[pos][prev][left];

		int answer = 0;

	// put all possible values 
	// greater equal to prev
		for (int i = prev; i <= left; i++) {
			answer += calculateDp(pos + 1, i, left - i, k);
		}

		return dp[pos][prev][left] = answer;
	}

}
