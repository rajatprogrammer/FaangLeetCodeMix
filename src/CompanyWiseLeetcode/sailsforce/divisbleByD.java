package CompanyWiseLeetcode.sailsforce;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/number-of-divisible-triplet-sums/
 * 2964. Number of Divisible Triplet Sums
Given a 0-indexed integer array nums and an integer d, return the number of triplets (i, j, k) such that i < j < k and (nums[i] + nums[j] + nums[k]) % d == 0.
Example 1:
Input: nums = [3,3,4,7,8], d = 5
Output: 3
Explanation: The triplets which are divisible by 5 are: (0, 1, 2), (0, 2, 4), (1, 2, 4).
It can be shown that no other triplet is divisible by 5. Hence, the answer is 3.
Example 2:
Input: nums = [3,3,3,3], d = 3
Output: 4
Explanation: Any triplet chosen here has a sum of 9, which is divisible by 3. Hence, the answer is the total number of triplets which is 4.
Example 3:
Input: nums = [3,3,3,3], d = 6
Output: 0
Explanation: Any triplet chosen here has a sum of 9, which is not divisible by 6. Hence, the answer is 0.
Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 109
1 <= d <= 109
Seen this question in a real interview before?
1/5
Fix index L to be the leftmost element of a triplet.
Hint 2
Starting from L, go forward and add the remainder of each element to a map.
Hint 3
Now when you are at index R, consider nums[L] + nums[R] and calculate what the remainder of the third element should be.
Hint 4
Discussion (2)
 * */
public class divisbleByD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,3,4,7,8};
		int d = 5;
		System.out.println(divisibleTripletCount(nums,d));
	}
	
	public static int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 2; i < n; i++) {
            int prev = nums[i - 1] % d;
            for (int j = i - 2; j >= 0; j--) {
                int v = (nums[j] + prev) % d;
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
            int v = nums[i] % d;
            ans += (v == 0) ? map.getOrDefault(0, 0) : map.getOrDefault(d - v, 0);
        }
        return ans;
    }

}
