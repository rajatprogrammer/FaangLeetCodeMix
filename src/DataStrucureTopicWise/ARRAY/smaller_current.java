package DataStrucureTopicWise.ARRAY;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/*How Many Numbers Are Smaller Than the Current Number
Easy

1678

42

Add to List

Share
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class smaller_current {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {7,7,7,7};
		System.out.print(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int res[] = new int[nums.length];
		HashMap<Integer, List<Integer>> hs = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.containsKey(nums[i])) {
				List<Integer> temp = hs.get(nums[i]);
				temp.add(i);
				hs.put(nums[i], temp);
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				hs.put(nums[i], temp);
			}
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (hs.containsKey(nums[i])) {
				if (hs.get(nums[i]).size() > 1) {
					List<Integer> idx = hs.get(nums[i]);
					for (int mo : idx) {
						res[mo] = i;
					}
					hs.remove(nums[i]);
				} else {
					int idx = hs.get(nums[i]).get(0);
					res[idx] = i;
					hs.remove(nums[i]);
				}
			}
		}
		return res;

	}

}
