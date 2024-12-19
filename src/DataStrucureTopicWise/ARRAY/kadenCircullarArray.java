package DataStrucureTopicWise.ARRAY;
//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class kadenCircullarArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,-2,3,-2};
		System.out.println(maxSubarraySumCircular(arr));
	}
	
	 public static int maxSubarraySumCircular(int[] A) {
	        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
	        for (int a : A) {
	            curMax = Math.max(curMax + a, a);
	            maxSum = Math.max(maxSum, curMax);
	            curMin = Math.min(curMin + a, a);
	            minSum = Math.min(minSum, curMin);
	            total += a;
	        }
	        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	      }

}
