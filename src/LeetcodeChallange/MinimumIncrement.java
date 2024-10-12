package LeetcodeChallange;
import java.util.Arrays;
//https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14
public class MinimumIncrement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,1,2,1,7};
		System.out.println(minIncrementForUnique(arr));
	}
	 public static int minIncrementForUnique(int[] nums) {
	        Arrays.sort(nums);
	        int ans = 0;
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] <= nums[i - 1]) {
	                ans += nums[i - 1] - nums[i] + 1;
	                nums[i] = nums[i - 1] + 1;
	            }
	        }
	        return ans;
	    }

}
