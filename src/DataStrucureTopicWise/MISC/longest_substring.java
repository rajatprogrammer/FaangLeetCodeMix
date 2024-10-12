package MISC;


/*Longest Common Substring | DP-29
Given two strings �X� and �Y�, find the length of the longest common substring.
Examples :

Input : X = �GeeksforGeeks�, y = �GeeksQuiz�
Output : 5
The longest common substring is �Geeks� and is of length 5.

Input : X = �abcdxyz�, y = �xyzabcd�
Output : 4
The longest common substring is �abcd� and is of length 4.

Input : X = �zxabcdezy�, y = �yzabcdezx�
Output : 6
The longest common substring is �abcdez� and is of length 6.*/
import java.lang.reflect.Array;
import java.util.Arrays;

public class longest_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "LAPJAAD";
		String y = "JAT";
		longest_substring.no_space_optimize_dynamic_programing(x,y,x.length(),y.length());

	}
	static void no_space_optimize_dynamic_programing(String X,String Y,int m,int n) {
		// Create a table to store lengths of longest common 
        // suffixes of substrings.   Note that LCSuff[i][j] 
        // contains length of longest common suffix of X[0..i-1] 
        // and Y[0..j-1]. The first row and first column entries 
        // have no logical meaning, they are used only for 
        // simplicity of program 
        int[][] LCSuff = new int[m + 1][n + 1]; 
  
        // To store length of the longest common substring 
        int len = 0; 
  
        // To store the index of the cell which contains the 
        // maximum value. This cell's index helps in building 
        // up the longest common substring from right to left. 
        int row = 0, col = 0; 
  
        /* Following steps build LCSuff[m+1][n+1] in bottom 
           up fashion. */
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) 
                    LCSuff[i][j] = 0; 
  
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
                    LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1; 
                    if (len < LCSuff[i][j]) { 
                        len = LCSuff[i][j]; 
                        row = i; 
                        col = j; 
                    } 
                } 
                else
                    LCSuff[i][j] = 0; 
            } 
        } 
  
        // if true, then no common substring exists 
        if (len == 0) { 
            System.out.println("No Common Substring"); 
            return; 
        } 
  
        // allocate space for the longest common substring 
        String resultStr = ""; 
  
        // traverse up diagonally form the (row, col) cell 
        // until LCSuff[row][col] != 0 
        while (LCSuff[row][col] != 0) { 
            resultStr = X.charAt(row - 1) + resultStr; // or Y[col-1] 
            --len; 
  
            // move diagonally up to previous cell 
            row--; 
            col--; 
        } 
  
        // required longest common substring 
        System.out.println(resultStr);
        for (int[] u: LCSuff) {
            for (int elem: u) {
                System.out.print(elem);
            }
            System.out.println();
        }
    } 
	}
