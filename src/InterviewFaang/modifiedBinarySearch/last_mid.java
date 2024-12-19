package InterviewFaang.modifiedBinarySearch;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
/**
 * 
 * @author rajat Given an array of integers nums sorted in ascending order, find
 *         the starting and ending position of a given target value.
 * 
 *         If target is not found in the array, return [-1, -1].
 * 
 *         Follow up: Could you write an algorithm with O(log n) runtime
 *         complexity?
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] Example 3:
 * 
 *         Input: nums = [], target = 0 Output: [-1,-1]
 */
public class last_mid {
	static int start = -1;
	static int end = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 7, 0, 0, 0, 10 };
		last_mid ob1 = new last_mid();
		ob1.binarySearch(0, arr.length - 1, arr, 8);
		System.out.print("start" + start + "end" + end);

	}

	public void binarySearch(int low, int high, int arr[], int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				if (start == -1 && end == -1) {
					start = binarySearchModifiedLow(0, mid, arr, target);
					end = binarySearchModifiedHigh(mid, arr.length - 1, arr, target);
					break;
				}
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	}

	public int binarySearchModifiedLow(int low, int high, int arr[], int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target && (mid - 1) >= 0 && arr[mid - 1] != target) {
				return mid;
			}
			if (arr[mid] == target) {
				high = mid - 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				return -1;
			}
		}
		return 0;
	}

	public int binarySearchModifiedHigh(int low, int high, int arr[], int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target && (mid + 1) < arr.length && arr[mid + 1] != target) {
				return mid;
			}
			if (arr[mid] == target) {
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				return -1;
			}
		}
		return arr.length - 1;
	}

}
