package DataStrucureTopicWise.STACK;

import java.util.Stack;

//https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
/*768. Max Chunks To Make Sorted II
Solved
Hard
Topics
Companies
Hint
You are given an integer array arr.

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.
 * */
public class MaxChunkTOSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int maxChunksToSorted(int[] arr) {
	        Stack<Integer> a= new Stack<Integer>();
	        for(int i=0;i<arr.length;i++)
	        {
	            int mx=arr[i];
	            while(!a.isEmpty()&&arr[i]<a.peek())
	            {
	                mx= Math.max(mx,a.peek());
	                a.pop();
	            }

	            a.push(mx);
	        }
	        return(a.size());
	    }
	
	

}
