package CompanyWiseLeetcodeGoogle;

/*
 * Given array of positive nums and a num K, select 2 ranges of size K consecutives that sum is maximized
Ex: arr = {10, 20, 3, 4, 8, 19} K = 2
ans = 57 (10 + 20) + (8 + 19)

I made 1 prefix sum for the first sequence and 1 suffix range max starting at >= I for the second range

So I can set any idx for starting and calculate its sum in O(1) and the best second range that starts at i + k in constant time
I can check among all possible idx and answer for each idx in constant time

Solution O(n)
 * 
 * */
public class max2Rangers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, -20, 3, 4, 8, 19};
		int k=2;
		System.out.println(maxTwoRangesSum(arr,k));
	}
	
	public static int maxTwoRangesSum(int[] arr, int k) {
        int n = arr.length;
        if (2 * k > n) return -1; // Not enough elements to pick two ranges
        
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        
        int maxSum = 0;
        int[] leftMax = new int[n];
        int maxLeft = 0;
        
        for (int i = k - 1; i < n; i++) {
            int sum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            maxLeft = Math.max(maxLeft, sum);
            leftMax[i] = maxLeft;
        }
        
        for (int j = k; j < n - k + 1; j++) {
            int sum2 = prefixSum[j + k] - prefixSum[j];
            maxSum = Math.max(maxSum, leftMax[j - 1] + sum2);
        }
        
        return maxSum;
    }

}
