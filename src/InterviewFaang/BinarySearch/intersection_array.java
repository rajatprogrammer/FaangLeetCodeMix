package InterviewFaang.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//facebook
//https://sugarac.gitbooks.io/facebook-interview-handbook/content/sliding-window-maximum/intersection-of-two-arrays-ii.html
/*Given two arrays, write a function to compute their intersection.

Example:
Givennums1=[1, 2, 2, 1],nums2=[2, 2], return[2, 2].

Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
 * */
public class intersection_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[] = {2,1,2,1};
		int num2[] = {2,2};
		System.out.print(Arrays.toString(intersect(num1,num2)));
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		    List<Integer> res = new ArrayList<>();
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
	            if (nums1[i] < nums2[j]) {
	                i++;
	            } else if (nums1[i] == nums2[j]) {
	                res.add(nums1[i]);
	                i++;
	                j++;
	            } else {
	                j++;
	            }
	        }
	        int[] result = new int[res.size()];
	        for (int i = 0; i < res.size(); i++) {
	            result[i] = res.get(i);
	        }
	        return result;
	}

}
