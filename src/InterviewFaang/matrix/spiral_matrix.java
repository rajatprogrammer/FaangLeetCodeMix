package matrix;

import java.util.List;

//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
//https://leetcode.com/problems/spiral-matrix/
//amazon
public class spiral_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		//recursive is easy only take colum when print row
		printRecusrive(mat, 4, 4,0,0);
	}

	public static void print(int a[][], int m, int n) {
		int i, k = 0, l = 0;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}
	//made by rajat
	public static void printRecusrive(int arr[][], int R, int C,int r,int c) {
		if(r>=R || c>=C) {
			return;
		}
		
		//for first row;
		for(int p=c;p<R;p++) {
			System.out.print(arr[c][p] + " ");
		}
		//for first col
		for(int p=r+1;p<C;p++) {
			System.out.print(arr[p][C-1] + " ");
		}
		//for last row
		if(r<R) {
			for(int p=C-2;p>=r;p--) {
				System.out.print(arr[R-1][p] + " ");
			}
		}
		//for last colum
		if(c<C) {
			for(int p=R-2;p>c;p--) {
				System.out.print(arr[p][c] + " ");
			}
		}
		printRecusrive(arr,R-1,C-1,r+1,c+1);
	}
	
	  public void spiralMatrix(List<Integer> spiral, int[][] matrix, int firstRow, int lastRow, int firstColumn, int lastColumn) {
	        // Check to see if we have run out of bounds
	        if (firstRow > lastRow || firstColumn > lastColumn)
	            return;
	        
	        // Top row: left to right
	        for (int i = firstColumn; i <= lastColumn; i++) {
	            spiral.add(matrix[firstRow][i]);
	        }
	        // Last column: top to bottom
	       for (int i = firstRow + 1; i <= lastRow; i++) {
	           spiral.add(matrix[i][lastColumn]);
	       }
	        // Check if we have processsed the last row or column 
	      if (firstRow == lastRow || firstColumn == lastColumn)
	          return;
	        
	        //Bottom row: right to left
	       for (int i = lastColumn - 1; i >= firstColumn; i--) {
	           spiral.add(matrix[lastRow][i]);
	       }
	        //First column: bottom to top
	        for (int i = lastRow - 1; i >= firstRow + 1; i--) {
	            spiral.add(matrix[i][firstColumn]);
	        }
	        // Recursion for bigger matrices
	        spiralMatrix(spiral, matrix, firstRow+1, lastRow-1, firstColumn+1, lastColumn-1);
	    }
	

}
