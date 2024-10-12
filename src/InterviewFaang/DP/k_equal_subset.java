package DP;
//https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

public class k_equal_subset {
	int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4, 3, 2, 3, 5, 2, 1};
		int k=4;
		k_equal_subset ob1 = new k_equal_subset();
		System.out.print(ob1.canPartitionKSubsets(arr,k));
	}
	//Not Optimized working fine(desined by rajat)
//	 public boolean canPartitionKSubsets(int[] nums, int k) {
//	    int sum=0;
//	    for(int i=0;i<nums.length;i++) {
//	    	sum = sum +nums[i];
//	    }
//	    if(sum%k!=0) {
//	    	return false;
//	    }
//	    else {
//	    	sum=sum/k;
//	    	int count=countSum(nums,sum,0,0);
//	    	if(count>=k) {
//	    		return true;
//	    	}else {
//	    		return false;
//	    	}
//	    }
//	 }
//	  int countSum(int nums[],int Sum,int i, int curr) {
//		  if(curr==Sum) {
//			  return 1;
//		  }
//		  if(curr>Sum) {
//			  return 0;
//		  }
//		  if(i>=nums.length) {
//			  return 0;
//		  }
//		  return countSum(nums,Sum,i+1,curr+nums[i]) + countSum(nums,Sum,i+1,curr);
//	 }
	//taking help for dfs approach
public  boolean canPartitionKSubsets(int[] nums, int k) {
        
        int t = 0 ;                
        for(int i=0;i<nums.length;i++)
            t +=nums[i];
        if(t % k != 0)return false;
         int target = t/k;   

        boolean[]visited = new boolean[nums.length];
       
    
      return partition(0,visited,nums,k,target,0); 
    }
    
  public  boolean partition(int index,boolean[]visited,int[]nums,int k,int target,int sum){
      if(k == 0){
          return true;
      }
      if(target == sum){
          return partition(0,visited,nums,k - 1,target,0); 
      }
      
      for(int i = index ; i < nums.length ; i++){
          if(!visited[i] && sum + nums[i] <= target){
              visited[i] = true;
              if( partition(i + 1,visited,nums,k ,target ,sum+nums[i]) ){
                  return true;
              }
            visited[i] = false;  
          }
      }
      return false;
    }
}
