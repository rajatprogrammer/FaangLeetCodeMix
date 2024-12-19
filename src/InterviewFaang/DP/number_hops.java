package InterviewFaang.DP;
//https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
public class number_hops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countWaysRecursive(4));
		System.out.print(dp(4));
	}
	static int countWaysRecursive(int n)
    {
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		int total =countWaysRecursive(n-1)+countWaysRecursive(n-2)+countWaysRecursive(n-3);
		return total;      
    }
	static int dp(int n) {
		int dp[] = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-2]+dp[i-1]+dp[i-3];
		}
		return dp[n];
	}

}
