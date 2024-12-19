package InterviewFaang.DP;
//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
//Amazon
public class difference_subset_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 6, 11, 5};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		System.out.println(findMinRec(arr,arr.length-1,0,sum));
		System.out.println(findMinDp(arr,sum));
	}

	public static int findMinRec(int arr[], int i, int sumCalculated, int sumTotal) {
		if(i==0) {
			return Math.abs((sumTotal-sumCalculated)-sumCalculated);
		}else {
			return Math.min(findMinRec(arr,i-1,sumCalculated+arr[i],sumTotal),findMinRec(arr, i-1, sumCalculated, sumTotal));
		}
	}
	public static int findMinDp(int arr[],int sum) {
		boolean dp[][] = new boolean[arr.length+1][sum+1];
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(j-arr[i-1]>=0) {
				dp[i][j] = dp[i][j-arr[i-1]]||dp[i-1][j];	
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		int diff = Integer.MAX_VALUE; 
		for(int j=sum/2;j>=0;j--) {
			if(dp[arr.length][j]) {
				diff= sum-2*j;
				break;
			}
		}
		return diff;
	}

}
