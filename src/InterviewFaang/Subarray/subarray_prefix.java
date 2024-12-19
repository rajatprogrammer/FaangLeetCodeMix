package InterviewFaang.Subarray;

import java.util.HashMap;

import org.omg.CORBA.MARSHAL;

//https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
//amazon
/**
 * 
 * @author rajat 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 *         Medium
 * 
 *         436
 * 
 *         23
 * 
 *         Add to List
 * 
 *         Share Given an array of integers arr and an integer target.
 * 
 *         You have to find two non-overlapping sub-arrays of arr each with sum
 *         equal target. There can be multiple answers so you have to find an
 *         answer where the sum of the lengths of the two sub-arrays is minimum.
 * 
 *         Return the minimum sum of the lengths of the two required sub-arrays,
 *         or return -1 if you cannot find such two sub-arrays.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: arr = [3,2,2,4,3], target = 3 Output: 2 Explanation: Only two
 *         sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 *         Example 2:
 * 
 *         Input: arr = [7,3,4,7], target = 7 Output: 2 Explanation: Although we
 *         have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and
 *         [7]), but we will choose the first and third sub-arrays as the sum of
 *         their lengths is 2. Example 3:
 * 
 *         Input: arr = [4,3,2,6,2,3,4], target = 6 Output: -1 Explanation: We
 *         have only one sub-array of sum = 6. Example 4:
 * 
 *         Input: arr = [5,5,4,4,5], target = 3 Output: -1 Explanation: We
 *         cannot find a sub-array of sum = 3. Example 5:
 * 
 *         Input: arr = [3,1,1,1,5,1,2,1], target = 3 Output: 3 Explanation:
 *         Note that sub-arrays [1,2] and [2,1] cannot be an answer because they
 *         overlap.
 * 
 */
public class subarray_prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 2, 2, 4, 3 };
		int target = 3;
		System.out.print(minSumOfLengths(arr, target));
	}

	public static int minSumOfLengths(int[] arr, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(0, -1);
		int resutl = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			hs.put(sum, i);
		}
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (hs.containsKey(sum - target)) {
				left = Math.min(left, i - hs.get(sum - target)); // for left check
			}
			if (hs.containsKey(sum + target) && left < Integer.MAX_VALUE) {
				resutl = Math.min(resutl, hs.get(sum + target) - i + left); // check for non overlapping
			}
		}

		return resutl == Integer.MAX_VALUE ? -1 : resutl;
	}

}
