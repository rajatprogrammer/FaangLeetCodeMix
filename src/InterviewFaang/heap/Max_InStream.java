package InterviewFaang.heap;
import java.util.Collections;
/*K’th largest element in a stream
Difficulty Level : Medium
 Last Updated : 04 Jul, 2019
Given an infinite stream of integers, find the k’th largest element at any point of time.
Example:

Input:
stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
k = 3

Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}


A Simple Solution is to keep an array of size k. The idea is to keep the array sorted so that the k’th largest element can be found in O(1) time (we just need to return first element of array if array is sorted in increasing order)
How to process a new element of stream?
For every new element in stream, check if the new element is smaller than current k’th largest element. If yes, then ignore it. If no, then remove the smallest element from array and insert new element in sorted order. Time complexity of processing a new element is O(k).

A Better Solution is to use a Self Balancing Binary Search Tree of size k. The k’th largest element can be found in O(Logk) time.
How to process a new element of stream?
For every new element in stream, check if the new element is smaller than current k’th largest element. If yes, then ignore it. If no, then remove the smallest element from the tree and insert new element. Time complexity of processing a new element is O(Logk).

An Efficient Solution is to use Min Heap of size k to store k largest elements of stream. The k’th largest element is always at root and can be found in O(1) time.
How to process a new element of stream?
Compare the new element with root of heap. If new element is smaller, then ignore it. Otherwise replace root with new element and call heapify for the root of modified heap. Time complexity of finding the k’th largest element is O(Logk).
 * */
import java.util.PriorityQueue;
import java.util.Queue;

public class Max_InStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20, 11, 70, 5,50, 40, 100};
		dequeCheck(arr,3);
	}
	
	public static void dequeCheck(int arr[],int k) {
		Queue<Integer> minHeapManageMaxValue = new PriorityQueue<Integer>();
		Queue<Integer> maxHeapManageMinValue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			if(minHeapManageMaxValue.size()<k) {
				minHeapManageMaxValue.add(arr[i]);
				maxHeapManageMinValue.add(arr[i]);
			}else {
				System.out.println("K max is"+ minHeapManageMaxValue.peek() + "Kth min is"+ maxHeapManageMinValue.peek());
				if(minHeapManageMaxValue.peek()<arr[i]) {
					minHeapManageMaxValue.poll();
					minHeapManageMaxValue.add(arr[i]);
				}
				if(maxHeapManageMinValue.peek()>arr[i]) {
					maxHeapManageMinValue.poll();
					maxHeapManageMinValue.add(arr[i]);
				}
			}
		}
	}

}
