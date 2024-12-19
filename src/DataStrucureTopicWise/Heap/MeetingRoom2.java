package DataStrucureTopicWise.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/description/
/*Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 
 * */
public class MeetingRoom2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(arr));
	}
	
	public static int minMeetingRooms(int[][] intervals) {
        
	    // Check for the base case. If there are no intervals, return 0
	    if (intervals.length == 0) {
	      return 0;
	    }

	    //min heap
	    PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(new Comparator<Integer>() {
			 public int compare(Integer a,Integer b) {
				 return a - b;
			 }
		});

	    // Sort the intervals by start time
	    Arrays.sort(
	        intervals,
	        new Comparator<int[]>() {
	          public int compare(final int[] a, final int[] b) {
	            return a[0] - b[0];
	          }
	        });

	    // Add the first meeting
	    allocator.add(intervals[0][1]);

	    // Iterate over remaining intervals
	    for (int i = 1; i < intervals.length; i++) {

	      // If the room due to free up the earliest is free, assign that room to this meeting.
	      if (intervals[i][0] >= allocator.peek()) {
	        allocator.poll();
	      }

	      // If a new room is to be assigned, then also we add to the heap,
	      // If an old room is allocated, then also we have to add to the heap with updated end time.
	      allocator.add(intervals[i][1]);
	    }

	    // The size of the heap tells us the minimum rooms required for all the meetings.
	    return allocator.size();
	  }
	
	

}
