package CompanyWiseLeetcodeGoogle;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
 * You are given an array nums consisting of positive integers.

Starting with score = 0, apply the following algorithm:

Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
Add the value of the chosen integer to score.
Mark the chosen element and its two adjacent elements if they exist.
Repeat until all the array elements are marked.
Return the score you get after applying the above algorithm.

 

Example 1:

Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
Our score is 1 + 2 + 4 = 7.
Example 2:

Input: nums = [2,3,5,1,3,2]
Output: 5
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
- 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
- 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
Our score is 1 + 2 + 2 = 5.

 * */
public class ScoreOfelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->a[0]!=b[0]?a[0] - b[0]:a[1]-b[1]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long sum = 0;
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int val = top[0], ind = top[1];
            if (vis[ind]) continue;
            sum += val;
            vis[ind] = true;
            if (ind - 1 >= 0) vis[ind - 1] = true;
            if (ind + 1 < n) vis[ind + 1] = true;
        }
        return sum;
    }

}
