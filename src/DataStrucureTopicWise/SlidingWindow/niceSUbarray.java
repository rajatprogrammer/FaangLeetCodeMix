package DataStrucureTopicWise.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-number-of-nice-subarrays
public class niceSUbarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static int numberOfSubarrays(int[] nums, int k) {

		Map<Integer,Integer> countMap = new HashMap<>();
		    
		  int oddsum= 0;
		    int count =0;
		    
		    for(int i=0;i< nums.length;i++)
		    {
		    
		        if(nums[i]%2 ==1)
		           oddsum++;
		        
		        if(oddsum==k)
		            count++;
		        
		        if(countMap.get(oddsum-k) !=null)
		        count = count+ countMap.get(oddsum-k);
		        
		        if(countMap.get(oddsum) == null)
		            countMap.put(oddsum , 1);
		        
		        else
		        {
		            countMap.put(oddsum , countMap.get(oddsum)+1);

		          }
		        
		    }
		return count;
		    
		    
		    
		}

}
