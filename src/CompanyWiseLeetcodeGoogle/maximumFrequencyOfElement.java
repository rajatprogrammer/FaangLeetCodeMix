package CompanyWiseLeetcodeGoogle;

import java.util.Arrays;

/*https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/
 * ou are given an integer array nums and two integers k and numOperations.

You must perform an operation numOperations times on nums, where in each operation you:

Select an index i that was not selected in any previous operations.
Add an integer in the range [-k, k] to nums[i].
Return the maximum possible 
frequency
 of any element in nums after performing the operations.

 

Example 1:

Input: nums = [1,4,5], k = 1, numOperations = 2

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1], after which nums becomes [1, 4, 5].
Adding -1 to nums[2], after which nums becomes [1, 4, 4].
Example 2:

Input: nums = [5,11,20,20], k = 5, numOperations = 1

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= k <= 109
0 <= numOperations <= nums.length
 * */
public class maximumFrequencyOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxNum = Arrays.stream(nums).max().orElse(0);
        int size = maxNum + k + 2;
        int[] freq = new int[size];

        // Build the frequency array
        for (int num : nums) {
            freq[num] += 1;
        }

        // Build the prefix sum array
        int[] pre = new int[size];
        pre[0] = freq[0];
        for (int i = 1; i < size; ++i) {
            pre[i] = pre[i - 1] + freq[i];
        }

        int result = 0;

        // Iterate through possible values of x
        for (int x = 0; x < size; ++x) {
            if (freq[x] == 0 && numOperations == 0) {
                continue;
            }
            int left = Math.max(0, x - k);
            int right = Math.min(size - 1, x + k);
            int totalInRange = pre[right] - (left > 0 ? pre[left - 1] : 0);
            int canAdjust = totalInRange - freq[x];
            int total = freq[x] + Math.min(numOperations, canAdjust);

            result = Math.max(result, total);
        }

        return result;
    }

}
