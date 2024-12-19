package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/description/
public class SUbset2 {
	List<List<Integer>> res=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        generate(nums,0,new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }
    public void generate(int nums[],int ind,List<Integer> arr)
    {
        int prev=-1;
        for(int i=ind;i<nums.length;i++)
        {
            if(prev==nums[i] && i>ind)
                continue;
            arr.add((nums[i]));
            res.add(new ArrayList<>(arr));
            generate(nums,i+1,arr);
            prev=arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
        }
    }

}
