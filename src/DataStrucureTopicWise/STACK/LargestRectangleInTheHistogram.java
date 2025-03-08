package DataStrucureTopicWise.STACK;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4
Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
Seen this question in a real interview before?
1/5
 * 
 * 
 * 
 * */
public class LargestRectangleInTheHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,1,5,6,2,3};
		System.out.println(optimizedHistogram(arr));
		
	}
	
	public static int optimizedHistogram(int heights[]) {
		  Deque<Integer> stack = new ArrayDeque<>();
	        stack.push(-1);
	        int length = heights.length;
	        int maxArea = 0;
	        for (int i = 0; i < length; i++) {
	            while (
	                (stack.peek() != -1) && (heights[stack.peek()] >= heights[i])
	            ) {
	                int currentHeight = heights[stack.pop()];
	                int currentWidth = i - stack.peek() - 1;
	                maxArea = Math.max(maxArea, currentHeight * currentWidth);
	            }
	            stack.push(i);
	        }
	        while (stack.peek() != -1) {
	            int currentHeight = heights[stack.pop()];
	            int currentWidth = length - stack.peek() - 1;
	            maxArea = Math.max(maxArea, currentHeight * currentWidth);
	        }
	        return maxArea;
	}
	
	
	public int bruteForce(int height[]) {
		int maxarea = 0;
		for(int i=0;i<height.length;i++) {
			for(int j=i;j<height.length;j++) {
				 int minheight = Integer.MAX_VALUE;
				 for (int k = i; k <= j; k++) minheight = Math.min(
		                    minheight,
		                    height[k]
		                );
		                maxarea = Math.max(maxarea, minheight * (j - i + 1));
			}
		}
		  return maxarea;		
	}

}
