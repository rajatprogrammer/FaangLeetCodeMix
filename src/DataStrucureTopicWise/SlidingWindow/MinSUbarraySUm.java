package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/minimum-size-subarray-sum/
//https://leetcode.com/problems/continuous-subarray-sum/
public class MinSUbarraySUm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s,nums));
	}
	
	 public static int minSubArrayLen(int s, int[] nums) {
	        if(nums==null || nums.length ==0) return 0;
	        int minlen = Integer.MAX_VALUE;
	        int sum =0;
	        int left =0;
	        for(int i=0; i<nums.length; i++){
	            sum += nums[i];
	            while(sum >=s){
	                minlen = Math.min(minlen,i-left+1);
	                sum -= nums[left];
	                left++;
	            }
	        }
	       return minlen == Integer.MAX_VALUE? 0: minlen; 
	    }

}
