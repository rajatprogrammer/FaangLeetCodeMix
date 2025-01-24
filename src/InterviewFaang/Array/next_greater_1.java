package InterviewFaang.Array;

import java.util.HashMap;

//https://leetcode.com/problems/next-greater-element-i/
public class next_greater_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int[] ans=new int[n];
        // using hashmap to store nums2 element with index;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int idx=0;
        for(int p:nums2) mpp.put(p, idx++);
        idx=0;
        for(int i =0 ;i<n ;i++){
            int num=nums1[i];
            for(int j=mpp.get(num)+1 ; j<nums2.length ;j++ ){
                if(nums2[j]>num){
                    ans[idx]=nums2[j];
                    break;
                }
            }
            if(ans[idx]==0) ans[idx]=-1;
            idx++;
        }
        return ans;
    }

}
