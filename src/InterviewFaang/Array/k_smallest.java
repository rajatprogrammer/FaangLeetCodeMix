package InterviewFaang.Array;
//https://leetcode.com/problems/kth-missing-positive-number/
public class k_smallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,4,7,11};
		System.out.print(findKthPositive(arr,5));
	}
	 public static int findKthPositive(int[] arr, int k) {
	        int n =0;
	        int itr=1;
	        int count=0;
	        while(n<arr.length){
	            if(arr[n]!=itr){
	                count++;
	            }
	            if(arr[n]==itr){
	                n++;
	            }
	            if(count==k){
	                return itr;
	            }
	             itr++;
	        }
	        if(count==0){
	            return itr+k-1;    
	        }else{
	            return itr + (k-count-1);
	        }
	        
	    }

}
