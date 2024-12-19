package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class subset_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3};
		subset_sum ob1 = new subset_sum();
		ob1.subsets(nums);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> resul= new ArrayList<List<Integer>>();
		return sub(0, nums, resul);
    }
    public ArrayList<List<Integer>>sub(int i,int nums[],ArrayList<List<Integer>> out){
		 if(i==nums.length-1) {
			 out.add(new ArrayList<Integer>());
			 ArrayList<Integer> as = new ArrayList<Integer>();
			 as.add(nums[i]);
			 out.add(as);
			 return out;
		 }else {
			 ArrayList<List<Integer>> backtrack=sub(i+1,nums,out);
			 int size = backtrack.size();
			 for(int k=0;k<size;k++) {
				 List<Integer> temp = new ArrayList<Integer>();
				 temp.addAll(backtrack.get(k));
				 temp.add(nums[i]);
				 backtrack.add(temp);
			 }
			 return backtrack;
		 }
	 }


}
