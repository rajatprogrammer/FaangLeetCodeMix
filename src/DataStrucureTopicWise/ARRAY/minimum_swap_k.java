package DataStrucureTopicWise.ARRAY;
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//flipkart adobe

//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987607/O(n)-explanation-with-picture
public class minimum_swap_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {1,0,0,0,0,0,1,1};
		int k=3;
		System.out.println(minMoves(nums,k));
	}
	 public static int minMoves(int[] nums, int k) {
		 List<Integer> ones = new ArrayList<>();
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == 1) {
	                ones.add(i);
	            }
	        }
	        int prefSum[]=new int[ones.size()];
	        prefSum[0] =ones.get(0);
	        for(int i = 1; i < ones.size(); i++)
	            prefSum[i] = prefSum[i - 1] + ones.get(i);    
	        int minMoves = Integer.MAX_VALUE;
	        int left = 0;
	        int right = k - 1;
	        while(right<ones.size()){
	            if(k%2==0){
	                int mid = (left + right) / 2;
	                int radius=mid-left;
	                int excessMoves;int total=0;
	               int lsum=(mid == 0 ? 0 : prefSum[mid-1]) - (left == 0 ? 0 : prefSum[left-1]);
	              int rsum=prefSum[right]-prefSum[mid] ;
	               excessMoves=radius*(radius+1)+(radius+1);
	               total=rsum-lsum-ones.get(mid)-(excessMoves);
	               minMoves=Math.min(minMoves,total);
	            }
	            else{
	                int mid = (left + right) / 2;
	                int radius=mid-left;
	                int excessMoves;
	                int total=0;
	               int lsum=(mid == 0 ? 0 : prefSum[mid - 1]) - (left == 0 ? 0 : prefSum[left - 1]);
	              int rsum=prefSum[right]-prefSum[mid] ;
	               excessMoves=radius*(radius+1);
	               total=rsum-lsum-(excessMoves);
	                minMoves=Math.min(minMoves,total);
	            }
	            left+=1;
	            right+=1;
	        }
	       
	   return minMoves;
	    }
	

}
