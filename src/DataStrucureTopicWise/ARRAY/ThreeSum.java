package DataStrucureTopicWise.ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
	public static void main(String[] args) {
		int nums[] = {-1,0,1,2,-1,-4};
		System.out.println(threeSumBruteFroce(nums));
	}
	//below brute force
	public static List<List<Integer>> threeSumBruteFroce(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> hash_Set = new HashSet<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int target=0;
		for(int i=0;i<nums.length;i++) {
			int j=i+1;
			int k=nums.length-1;			
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == target) {
					hash_Set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
                    k--;
				}else if(sum<target) {
					j++;
				}else {
					k--;
				}
			}
		}
		res.addAll(hash_Set);
        return res;
    }
	public static List<List<Integer>> threeSumOptimized(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> hash_Set = new HashSet<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int target=0;
		for(int i=0;i<nums.length;i++) {
			int j=i+1;
			int k=nums.length-1;			
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == target) {
					hash_Set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
                    k--;
				}else if(sum<target) {
					j++;
				}else {
					k--;
				}
			}
		}
		res.addAll(hash_Set);
        return res;
    }

}
