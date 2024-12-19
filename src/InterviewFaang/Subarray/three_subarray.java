package InterviewFaang.Subarray;
//https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
/*A split of an integer array is good if:

The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.
Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
 * */
public class three_subarray {
	static final int MOD=1000000007;
	 public static int waysToSplit(int[] nums) {
	        int  len=nums.length;
	        for(int i=1;i<len;i++) {
	            nums[i]+=nums[i-1];
	        }
	        int l=0,r=0,cnt=0;
	        for(int i=0;i<len;i++) {
	            l=Math.max(i+1,l);
	            while(l<len&&nums[l]-nums[i]<nums[i]) l++;
	            r=Math.max(l,r);
	            while(r<len-1&&nums[len-1]-nums[r]>=nums[r]-nums[i]) r++;
	            cnt+=r-l;
	            cnt%=MOD;
	        }
	        return cnt;
	    }
	public static void main(String[] args) {
		int arr[] = {1,2,2,2,5,0};
		System.out.print(waysToSplit(arr));

	}
	

}
