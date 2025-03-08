package DataStrucureTopicWise.BackTracking;

/*
 * https://leetcode.com/problems/path-with-maximum-gold/description/
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
 * 
 * 
 * 
 * */
public class MaxPathSumWithGOld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 private final int[] DIRECTIONS = new int[] { 0, 1, 0, -1, 0 };
	    public int getMaximumGold(int[][] grid) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        int maxGold = 0;

	        // Search for the path with the maximum gold starting from each cell
	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                maxGold = Math.max(maxGold, dfsBacktrack(grid, rows, cols, row, col));
	            }
	        }
	        return maxGold;
	    }

	    private int dfsBacktrack(int[][] grid, int rows, int cols, int row, int col) {
	        // Base case: this cell is not in the matrix or this cell has no gold
	        if (row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
	            return 0;
	        }
	        int maxGold = 0;

	        // Mark the cell as visited and save the value
	        int originalVal = grid[row][col];
	        grid[row][col] = 0;

	        // Backtrack in each of the four directions
	        for (int direction = 0; direction < 4; direction++) {
	            maxGold = Math.max(maxGold,
	                    dfsBacktrack(grid, rows, cols, DIRECTIONS[direction] + row,
	                            DIRECTIONS[direction + 1] + col));
	        }

	        // Set the cell back to its original value
	        grid[row][col] = originalVal;
	        return maxGold + originalVal;
	    }

}
