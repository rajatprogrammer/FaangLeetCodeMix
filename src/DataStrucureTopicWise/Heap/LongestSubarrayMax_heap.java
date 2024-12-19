package DataStrucureTopicWise.Heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
public class LongestSubarrayMax_heap {

	public static void main(String[] args) {
	 int nums[] = {8,2,4,7};
	 int limit=4;
	 System.out.println(longestSubarray(nums,limit));
	}
	public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int ans = 1;
        for (int i = 0, j = 0; i < nums.length; i ++) {
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
            while (! isValid(minHeap, maxHeap, limit)) {
                minHeap.remove(nums[j]);
                maxHeap.remove(nums[j]);
                j ++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
    
    private static boolean isValid(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int limit) {
        return maxHeap.peek() - minHeap.peek() <= limit;
    }

}
