package BinarySearch;
//https://leetcode.com/problems/search-a-2d-matrix/
public class search2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public boolean searchMatrix (int[][] matrix, int target) {
		
		int m = matrix.length;
        if (m == 0) {
            return false;
        }
		int n = matrix[0].length;
		if (n == 0) {
			return false;
		}
		else if (target > matrix[m - 1][n - 1]) {
			return false;
		}
		
		int row = 0;
		while (row < m && target > matrix[row][n - 1]) {
			++row;
		}
		
		int start_col = 0;
		int last_col = n - 1;
		while (start_col <= last_col) {
			int mid_col = (start_col + last_col) / 2;
			if (matrix[row][mid_col] == target) {
				return true;
			}
			else if (matrix[row][mid_col] < target) {
				start_col = mid_col + 1;
			}
			else {
				last_col = mid_col - 1;
			}
		}
		
		return false;
	}

}
