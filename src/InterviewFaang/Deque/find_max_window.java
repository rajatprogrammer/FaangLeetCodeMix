package Deque;

import java.util.Deque;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class find_max_window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int K=4;
		getkMax(arr,K);
	}
	
	public static void getkMax(int arr[],int k) {
		int i = 0;
		Deque<Integer> dq = new LinkedList<Integer>();
		for(i=0;i<k;i++) {
			while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for(;i<arr.length;i++) {
			System.out.println("Max Window" + arr[dq.peekFirst()]);
			if(!dq.isEmpty() && i-dq.peekFirst()>=k) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.println("Max Window" + arr[dq.peekFirst()]);
	}
}
