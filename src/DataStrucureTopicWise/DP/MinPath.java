package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/triangle
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinPath {

	private Map<String, Integer> memoTable;
    private List<List<Integer>> triangle;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    private int minPath(int row, int col) {
    	
        String params = row + ":" + col;
        
        if (memoTable.containsKey(params)) {
            return memoTable.get(params);
        } 
        
        int path = triangle.get(row).get(col);
        
        if (row < triangle.size() - 1) {
            path += Math.min(minPath(row + 1, col), minPath(row + 1, col + 1));
        }
        
        memoTable.put(params, path);
        
        return path;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        memoTable = new HashMap<>();
        return minPath(0, 0);
    }

}
