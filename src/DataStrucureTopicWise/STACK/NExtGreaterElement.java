package DataStrucureTopicWise.STACK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/
public class NExtGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {4,1,2}, nums2[] = {1,3,4,2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();

            if(stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++)
            nums1[i] = map.get(nums1[i]);

        return nums1;
    }

}
