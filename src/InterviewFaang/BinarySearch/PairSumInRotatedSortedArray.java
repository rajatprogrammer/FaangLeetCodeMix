package InterviewFaang.BinarySearch;
/*
 * https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/?ref=rp
 * Given an array that is sorted and then rotated around an unknown point. Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct.
Examples :

Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.
 * */
public class PairSumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11, 15, 26, 38, 9, 10};
		System.out.println(SortedRotatedPair(arr,19));
		System.out.println(countPairSum(arr,19));
	}
	
	public static boolean SortedRotatedPair(int arr[],int sum) {
		int pivort=0;
		int len = arr.length;
		int i=0;
		for(i=0;i<len-1;i++) {
			if(arr[i]>arr[i+1]) {
				pivort = i;
				break;
			}
		}
			int low= (i+1)%len;
			int high = i;
			
			while(low!=high) {
				if(arr[low] + arr[high]==sum) {
					return true;
				}
				else if((arr[low] + arr[high])<=sum) {
					low = (low+1)%len;
				}else {
					high = (high-1 +len)%len;
				}
			}
		return false;
	}
	
	static public int countPairSum(int arr[],int sum) {
		int pivort=0;
		int count=0;
		int len = arr.length;
		int i=0;
		for(i=0;i<len-1;i++) {
			if(arr[i]>arr[i+1]) {
				pivort = i;
				break;
			}
		}
			int low= (i+1)%len;
			int high = i;
		while(low!=high) {
			if(arr[low] + arr[high]==sum) {
				count++;
				if(low==(high-1 +len)%len) {
					return count;
				}
			}
			else if((arr[low] + arr[high])<=sum) {
				low = (low +1)%len;
			}else {
				high = (high-1 + len)%len;
			}
		}
		return 0;
	}
	

}
