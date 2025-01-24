package InterviewFaang.DP;
//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
//amazon,paypal

import java.util.Arrays;
import java.util.HashMap;

public class longest_subsequence {

	static HashMap<Integer, HashMap<Integer,Integer>> hp = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="GEEKSFORGEEKS";
		int dp[][] = new int[str.toCharArray().length][str.toCharArray().length];
		for(int[] x:dp) {
			Arrays.fill(x, -1);
		}
		System.out.println(lpsRecursive(str.toCharArray(),0,str.length()-1));
		System.out.println(lpsDP(str));
		System.out.println(lpsRecursiveDpMemoise(str.toCharArray(),0,str.length()-1,dp));
	}
	
	static int lpsRecursiveDpMemoise(char seq[], int i, int j,int dp[][]) { 
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
	    // Base Case 1: If there is only 1 character 
	        if (i == j) { 
	        	dp[i][j]=1;
	            return 1; 
	        } 
	  
	    // Base Case 2: If there are only 2 characters and both are same  
	        if (seq[i] == seq[j] && i + 1 == j) { 
	        	dp[i][j]=2;
	            return 2; 
	        } 
	  
	    // If the first and last characters match  
	        if (seq[i] == seq[j]) { 
	            int c= lpsRecursive(seq, i + 1, j - 1) + 2; 
	            dp[i][j]=c;
	            return c;
	        } 
	  
	    // If the first and last characters do not match  
	        int val =  Math.max(lpsRecursive(seq, i, j - 1), lpsRecursive(seq, i + 1, j)); 
	        dp[i][j] = val;
	        return val;
	  } 
	
	static int lpsRecursive(char seq[], int i, int j) { 
	    // Base Case 1: If there is only 1 character  
	        if (i == j) { 
	            return 1; 
	        } 
	  
	    // Base Case 2: If there are only 2 characters and both are same  
	        if (seq[i] == seq[j] && i + 1 == j) { 
	            return 2; 
	        } 
	  
	    // If the first and last characters match  
	        if (seq[i] == seq[j]) { 
	            return lpsRecursive(seq, i + 1, j - 1) + 2; 
	        } 
	  
	    // If the first and last characters do not match  
	        return Math.max(lpsRecursive(seq, i, j - 1), lpsRecursive(seq, i + 1, j)); 
	  } 
	static int lpsDP(String seq) 
    { 
    int n = seq.length(); 
    int i, j, cl; 
    // Create a table to store results of subproblems 
    int L[][] = new int[n][n];  
      
    // Strings of length 1 are palindrome of lentgh 1 
    for (i = 0; i < n; i++) 
        L[i][i] = 1; 
              
        // Build the table. Note that the lower  
        // diagonal values of table are 
        // useless and not filled in the process.  
        // The values are filled in a manner similar 
        //  to Matrix Chain Multiplication DP solution (See 
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).  
        // cl is length of substring 
        for (cl=2; cl<=n; cl++) 
        { 
            for (i=0; i<n-cl+1; i++) 
            { 
                j = i+cl-1; 
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) 
                L[i][j] = 2; 
                else if (seq.charAt(i) == seq.charAt(j)) 
                L[i][j] = L[i+1][j-1] + 2; 
                else
                L[i][j] = Math.max(L[i][j-1], L[i+1][j]); 
            } 
        } 
              
        return L[0][n-1]; 
    } 

}
