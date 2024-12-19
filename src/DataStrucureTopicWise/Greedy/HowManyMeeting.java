package DataStrucureTopicWise.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/description/
/*253. Meeting Rooms II
Solved
Medium
Topics
Companies
Hint
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 * */
public class HowManyMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(intervals));
	}	
	
	 public static int minMeetingRooms(int[][] intervals) {
		 
		 if (intervals.length == 0) {
		      return 0;
		 }
		 PriorityQueue<Integer> allocator = new PriorityQueue<>(
		    		new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							// TODO Auto-generated method stub
							return o1 - o2;
		  }
		    	
		 });
		 
		 Arrays.sort(intervals,
				 new Comparator<int[]>() {
			          public int compare(final int[] a, final int[] b) {
			            return a[0] - b[0];
			          }});
		 allocator.add(intervals[0][1]);
		 
		    for (int i = 1; i < intervals.length; i++) {
		    	//free room
		    	if( intervals[i][0]>=allocator.peek()) {
		    		allocator.poll();
		    	}
		    	
		    	allocator.add(intervals[i][1]);
		    }
		    
		    return allocator.size();
		           
	 }
	
	

}
