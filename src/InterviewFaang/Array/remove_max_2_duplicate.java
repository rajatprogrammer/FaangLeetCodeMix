package InterviewFaang.Array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class remove_max_2_duplicate {

	public static void main(String[] args) {
		int arr[] = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(arr));
	}
	public static int removeDuplicates(int[] nums) {
        int n = nums.length;
       if(n < 3)
           return n;  
       int i=2;
       for(int j=i;j<nums.length;j++){
           if(nums[i-2]!=nums[j]){
               nums[i++]=nums[j];
           }
       }
       return i;
   }
}
