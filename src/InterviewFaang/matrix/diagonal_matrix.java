package matrix;
/*
 * https://leetcode.com/problems/diagonal-traverse/
 * https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
 * Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]
 * */
public class diagonal_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{6,9,7}};
		findDiagonalOrder(arr);
	}
	public static int[] findDiagonalOrder(int[][] matrix) {	
      int i=0;
      int j=0;
      int R=matrix.length;
      int C=matrix[0].length;
      int res[] = new int[R*C];
      boolean top=true;
      for(int k=0;k<R*C;) {
    	  if(top) {
    		  for (; i >= 0 && j < C; j++, i--) { 
                  System.out.print(matrix[i][j] + " "); 
                  res[k]=matrix[i][j];
                  k++; 
              }
    		  if(i < 0 && j <= C - 1) {
    			  i = 0;   
    		  }else {
    			  i = i + 2; 
    			  j--;
    		  }
    	  }else {
    		  for (; j >= 0 && i < R; i++, j--) { 
                  System.out.print(matrix[i][j] + " "); 
                  res[k]=matrix[i][j];
                  k++; 
              } 

              // Set i and j according to direction 
              if (j < 0 && i <= R - 1) 
                  j = 0; 
              if (i == R) { 
                  j = j + 2; 
                  i--; 
              } 
    	  }
    	  top=!top;
      }
      return res;
       
    }

}
