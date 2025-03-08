package DataStrucureTopicWise.DP;

import java.util.Arrays;

public class minimumDeletionToAlmostSortedArray {
	
	public static int minDeletions(int[] arr) {
        int n = arr.length;
        int maxSortedLength = 1;
        
        // Find the longest increasing subsequence (LIS) to keep
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxSortedLength = Math.max(maxSortedLength, dp[i]);
        }
        
        // The minimum deletions required is total length - longest sorted sequence
        return n - maxSortedLength;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 7, 1};
        System.out.println("Minimum deletions: " + minDeletions(arr));
    }

}
