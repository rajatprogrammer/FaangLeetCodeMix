package DataStrucureTopicWise.recursion;
//https://leetcode.com/problems/distinct-subsequences/description/
public class distinctSubsequence {

	int [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numDistinct(String s, String t) {
        dp=new int [s.length()][t.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(s.length()-1,t.length()-1,s,t);
    }
    public int solve(int i,int j,String s, String t){
        if(j<0){
            return 1;
        }
        else if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(i-1,j-1,s,t)+solve(i-1,j,s,t);
        }
        else{
            return dp[i][j]=solve(i-1,j,s,t);
        }
    }
}

