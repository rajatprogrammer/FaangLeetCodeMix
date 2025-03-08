package InterviewFaang.Median;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/
public class median_sliding {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 1, 2, 0, 5 };
		int K = 3;
		System.out.print(Arrays.toString(maxSlidingWindow(arr, K)));
		System.out.print(Arrays.toString(maxSlidingWindowDeque(arr, K)));

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int output[] = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		int left = 0;
		int count = 0;
		for (int i = k; i < nums.length; i++) {
			output[count++] = pq.peek();
			pq.remove(nums[left++]);
			pq.add(nums[i]);
		}
		output[count] = pq.peek();
		return output;
	}

	public static int[] maxSlidingWindowDeque(int[] nums, int k) {
		Deque<Integer> q = new ArrayDeque<>();
		int len = nums.length, j = 0;
		int[] res = new int[len - k + 1]; // OUTPUT ARRAY will store indices of eligible candidates only till length-k+1
		for (int i = 0; i < len; i++) {

			while (q.size() > 0 && q.peek() <= i - k)
				q.poll(); // Remove from front all those indices which won't come in current window

			while (q.size() > 0 && nums[q.peekLast()] <= nums[i])
				q.pollLast();/*
								 * Remove those elements from rear which are <= to current element as current
								 * nums[i] will be max in future windows
								 */

			q.add(i); // Since above conditions removed unwanted candidates...add current index

			if (i >= k - 1) {// Consider window after first element only
				res[j++] = nums[q.peek()];
			}
		}
		return res;
	}

}
