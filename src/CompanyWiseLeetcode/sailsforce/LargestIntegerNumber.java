package CompanyWiseLeetcode.sailsforce;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
 *https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/?envType=company&envId=salesforce&favoriteSlug=salesforce-three-months
Solved
Easy
Topics
Companies
Hint
You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).

Return the largest possible value of num after any number of swaps.
 * */

public class LargestIntegerNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {6,5,8,7,5};
		System.out.println(largestInteger(nums));
	}
	
	 public static int largestInteger(int[] nums) {
	       HashMap<Integer,ArrayList<Integer>> hp = new HashMap<>();
	       hp.put(0,new ArrayList<Integer>());
	       hp.put(1,new ArrayList<Integer>());
	       	for(int i=0;i<nums.length;i++) {
	       		if(nums[i]%2==0) {
	       			ArrayList<Integer> temp=hp.get(0);
	       			temp.add(i);
	       			hp.put(0,temp);
	       		}else {
	       			ArrayList<Integer> temp=hp.get(1);
	       			temp.add(i);
	       			hp.put(1,temp);
	       		}
	       	}
	       	for(int i=0;i<nums.length;i++) {
	       			ArrayList<Integer> temp;
	       			if(nums[i]%2==0) {
	       				temp=hp.get(0);
	       			}else {
	       				temp=hp.get(1);
	       			} 			
	       			for(int x=0;x<temp.size();x++) {
	       				if(nums[i]<nums[temp.get(x)]) {
	       					int c = nums[i];
	       					nums[i] = nums[temp.get(x)];
	       					nums[temp.get(x)] = c;
	       					temp.remove(x);
	       					for(int y=0;y<temp.size();y++) {
	       						if(temp.get(y)==i) {
	       							temp.remove(y);
	       						}
	       					}
	       			}
	       		}	
	       	}
	       	
	       	String res = "";
	       	for(int x: nums) {
	       		res = res + x;
	       	}
	       	return Integer.parseInt(res);
	    }
	 
	 	public int largestInteger(int n){
	        char[] a = String.valueOf(n).toCharArray();
	        for(int i = 0; i < a.length; i++)
	            for(int j = i + 1; j < a.length; j++)
	                if(a[j] > a[i] && (a[j] - a[i]) % 2 == 0){
	                    char t = a[i];
	                    a[i] = a[j];
	                    a[j] = t;
	                }
	        return Integer.parseInt(new String(a));
	    }
}
