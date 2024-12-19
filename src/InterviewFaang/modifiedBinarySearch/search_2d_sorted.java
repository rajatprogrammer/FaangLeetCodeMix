package InterviewFaang.modifiedBinarySearch;

//https://leetcode.com/problems/search-a-2d-matrix/
/***
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * @author rajat
 *
 */
public class search_2d_sorted {

	public static void main(String[] args) {
		int mat[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target=3;
		System.out.print(searchMatrix(mat,target));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int m = matrix.length;
		if (m == 0) {
			return false;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return false;
		} else if (target > matrix[m - 1][n - 1]) {
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
			} else if (matrix[row][mid_col] < target) {
				start_col = mid_col + 1;
			} else {
				last_col = mid_col - 1;
			}
		}

		return false;
	}

}
