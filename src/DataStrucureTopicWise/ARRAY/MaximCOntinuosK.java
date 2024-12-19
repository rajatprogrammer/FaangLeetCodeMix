package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/
/*ou are given an integer array nums. In one operation, you can replace any element in nums with any integer.

nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.

 

Example 1:

Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.
Example 2:

Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.
Example 3:

Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.
 * */
public class MaximCOntinuosK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,4,7};
		System.out.println(minOperations(nums));
	}
	
	 public static int minOperations(int[] nums) {
	        int n = nums.length;
	        int ans = n;
	        
	        HashSet<Integer> unique = new HashSet<>();
	        for (int num : nums) {
	            unique.add(num);
	        }
	        
	        int[] newNums = new int[unique.size()];
	        int index = 0;
	        
	        for (int num : unique) {
	            newNums[index++] = num;
	        }
	            
	        Arrays.sort(newNums);
	        
	        for (int i = 0; i < newNums.length; i++) {
	            int left = newNums[i];
	            int right = left + n - 1;
	            int j = binarySearch(newNums, right);
	            int count = j - i;
	            ans = Math.min(ans, n - count);
	        }
	        
	        return ans;
	    }
	    
	    public static int binarySearch(int[] newNums, int target) {
	        int left = 0;
	        int right = newNums.length;
	        
	        while (left < right) {
	            int mid = (left + right) / 2;
	            if (target < newNums[mid]) {
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        }
	        
	        return left;
	    }

}
