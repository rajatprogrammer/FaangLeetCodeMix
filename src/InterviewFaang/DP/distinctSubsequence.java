package InterviewFaang.DP;

//https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
//https://leetcode.com/problems/distinct-subsequences/description/

public class distinctSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String T = "ge";
		String S = "geeksforgeeks";
		System.out.println(findSubsequenceCount(S, T));
		System.out.println(recursive(S, T, 0, 0));
	}

	static int findSubsequenceCount(String S, String T) {
		int m = T.length();
		int n = S.length();

		// T can't appear as a subsequence in S
		if (m > n)
			return 0;

		// mat[i][j] stores the count of
		// occurrences of T(1..i) in S(1..j).
		int mat[][] = new int[m + 1][n + 1];

		// Initializing first column with
		// all 0s. An emptystring can't have
		// another string as suhsequence
		for (int i = 1; i <= m; i++)
			mat[i][0] = 0;

		// Initializing first row with all 1s.
		// An empty string is subsequence of all.
		for (int j = 0; j <= n; j++)
			mat[0][j] = 1;

		// Fill mat[][] in bottom up manner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// If last characters don't match,
				// then value is same as the value
				// without last character in S.
				if (T.charAt(i - 1) != S.charAt(j - 1))
					mat[i][j] = mat[i][j - 1];

				// Else value is obtained considering two cases.
				// a) All substrings without last character in S
				// b) All substrings without last characters in
				// both.
				else
					mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
			}
		}

		/*
		 * uncomment this to print matrix mat for (int i = 1; i <= m; i++, cout << endl)
		 * for (int j = 1; j <= n; j++) System.out.println ( mat[i][j] +" ");
		 */
		return mat[m][n];
	}
	
	static int recursive(String T,String S,int t,int s) {
		if((t==T.length() && s==S.length() )|| s==S.length()) {
			return 1;
		}
		else if(t>=T.length()) {
			return 0;
		}
		if(S.charAt(s)==T.charAt(t)) {
			return (recursive(T,S,t+1,s+1) + recursive(T, S, t+1, s));
		}else {
			return(recursive(T, S, t+1, s));
		}
	}

}
