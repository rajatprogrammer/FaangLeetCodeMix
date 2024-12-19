package DataStrucureTopicWise.Subarray;

import java.util.Arrays;

//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=company&envId=adobe&favoriteSlug=adobe-six-months
public class SubbarrayMaxAppearKtimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,2,3,3};
		System.out.println(countSubarrays(arr,2));
	}
	
	public static long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0, start = 0;
        int maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            while (maxElementsInWindow == k) {
                if (nums[(int) start] == maxElement) {
                    maxElementsInWindow--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }

}
