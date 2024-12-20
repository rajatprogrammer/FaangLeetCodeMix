package InterviewFaang.matrix;
/*
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

public class sort_matrix_daigonally {

	public static void main(String[] args) {
		int mat[][] = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		System.out.println(Arrays.deepToString(diagonalSort(mat)));
	}
	 public static int[][] diagonalSort(int[][] mat) {
		HashMap<Integer, Queue<Integer>> hq=new HashMap<Integer, Queue<Integer>>();
	   for(int i=0;i<mat.length;i++) {
		   for(int j=0;j<mat[0].length;j++) {
			   hq.computeIfAbsent(i-j, p->new PriorityQueue<Integer>()).add(mat[i][j]);
		   }
	   }
	   for(int i=0;i<mat.length;i++) {
		   for(int j=0;j<mat[0].length;j++) {
			   mat[i][j] = hq.get(i-j).poll();
		   }
	   }
	   	return mat;
	 }

}
