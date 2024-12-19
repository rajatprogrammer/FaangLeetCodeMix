package InterviewFaang.BinarySearch;

import java.util.Arrays;


//https://www.geeksforgeeks.org/count-elements-less-equal-given-value-sorted-rotated-array/?ref=rp

/*https://www.geeksforgeeks.org/sort-rotated-sorted-array/?ref=rp
 * xpected to use O(1) extra space and O(n) time complexity.
Examples:

Input : [3, 4, 1, 2] 
Output : [1, 2, 3, 4]

Input : [2, 3, 4, 1]
Output : [1, 2, 3, 4]
 * */
public class sortarotatedsortarray {

	static int findStartIndexOfArray(int arr[], int low, int high) {
		if (low > high) {
			return -1;
		}

		if (low == high) {
			return low;
		}

		int mid = low + (high - low) / 2;
		if (arr[mid] > arr[mid + 1]) {
			return mid + 1;
		}

		if (arr[mid - 1] > arr[mid]) {
			return mid;
		}

		if (arr[low] > arr[mid]) {
			return findStartIndexOfArray(arr, low, mid - 1);
		} else {
			return findStartIndexOfArray(arr, mid + 1, high);
		}
	}

// Function to restore the Original Sort  
	static void restoreSortedArray(int arr[], int n) {
// array is already sorted  
		if (arr[0] < arr[n - 1]) {
			return;
		}

		int start = findStartIndexOfArray(arr, 0, n - 1);

// In reverse(), the first parameter  
// is iterator to beginning element  
// and second parameter is iterator  
// to last element plus one.  
		int last = arr.length-1;
		int started = 0;
		
		int low=0;
		while(arr[start]<arr[low] && start!=0) {
			if(arr[start]==arr[low]) {
				break;
			}
			swap(start, low, arr);
			start = (start+1)%n;
			low = low +1;
		}

	}

// Function to print the Array  
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void swap(int pos,int pos1,int arr[]) {
		int temp=arr[pos];
		arr[pos]=arr[pos1];
		arr[pos1]=temp;
	}

// Driver code 
	public static void main(String[] args) {
		int arr[] = {3, 4, 1, 2};
		int n = arr.length;
		restoreSortedArray(arr, n);
		printArray(arr, n);
	}

}
