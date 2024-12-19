package DataStrucureTopicWise.Subarray;
//https://leetcode.com/problems/minimizing-array-after-replacing-pairs-with-their-product/description/?envType=company&envId=adobe&favoriteSlug=adobe-six-months
public class Minimise_subarray_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,3,7,3,5};
		int K=20;
		System.out.println(minArrayLength(nums,K));
	}
	
	  public static int minArrayLength(int[] nums, int k) {
	        // check zero case
	        for(int num:nums)
	        {
	            if(num == 0) return 1;
	        }
	        int len = nums.length, left = 0,right= 0, res = nums.length; 
	        long product = 1;
	        if(len==1) return 1;
	        for(;right < len;right++)
	        {
	            product*=nums[right];
	            if(product > k)
	            {
	                product = nums[right];
	                res-=right-left-1;
	                left = right;
	            }
	        }
	        res-=right-left-1;
	        return res;
	    }

}
