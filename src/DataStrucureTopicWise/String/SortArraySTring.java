package DataStrucureTopicWise.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Topics
Companies
Hint
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 * 
 * */
public class SortArraySTring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a list of map entries, sorted by frequency, then value
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey(); // Descending order of values for same frequency
            }
            return a.getValue() - b.getValue(); // Ascending order of frequency
        });

        // Step 3: Populate the result array based on the sorted entries
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.add(key);
            }
        }

        // Convert the result list to an array
        return result.stream().mapToInt(i -> i).toArray();
    }

}
