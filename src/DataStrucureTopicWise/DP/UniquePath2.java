package DataStrucureTopicWise.DP;
//https://leetcode.com/problems/unique-paths-ii/description
public class UniquePath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 
            || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1 && dp[i-1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1 && dp[0][i-1] == 1) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
        
    }

}
