package DataStrucureTopicWise.STACK;

import java.util.PriorityQueue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * */
public class SUmOfSUbarrayMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2,4};
		System.out.println(sumSubarrayMins(arr));
	}
	
	 private static final int MOD = 1_000_000_007;

	    public static int sumSubarrayMins(int[] arr) {
	        int n = arr.length;
	        long sum = 0;

	        // Monotonic stack to find previous and next less elements
	        Stack<int[]> stack = new Stack<>();
	        int[] ple = new int[n]; // Previous Less Element index
	        int[] nle = new int[n]; // Next Less Element index

	        // Find Previous Less Element (PLE)
	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
	                stack.pop();
	            }
	            ple[i] = stack.isEmpty() ? -1 : stack.peek()[1];
	            stack.push(new int[]{arr[i], i});
	        }

	        stack.clear(); // Reset stack for NLE

	        // Find Next Less Element (NLE)
	        for (int i = n - 1; i >= 0; i--) {
	            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
	                stack.pop();
	            }
	            nle[i] = stack.isEmpty() ? n : stack.peek()[1];
	            stack.push(new int[]{arr[i], i});
	        }


	        // Compute contribution using PLE & NLE
	        for (int i = 0; i < n; i++) {
	            long left = i - ple[i];
	            long right = nle[i] - i;
	            long contribution = (left * right) % MOD * arr[i] % MOD;
	            sum = (sum + contribution) % MOD;

	        }

	        return (int) sum;
	    }

}
