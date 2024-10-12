package DP;

import java.util.Arrays;

//https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
//Input : arr[] = { 1, 2, 6, 5, 4}
//Output : 2
//We can change a[2] to any value 
//between 2 and 5.
//and a[4] to any value greater then 5. 
//
//Input : arr[] = { 1, 2, 3, 5, 7, 11 }
//Output : 0
//Array is already strictly increasing.
public class minimum_change_increasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 6, 5, 4};
		System.out.print(remove(arr));
	}
	public static int remove(int arr[]) {
		int dp[] = new int[arr.length];
		int len=0;
		Arrays.fill(dp,1);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(i>j && (arr[j]<arr[i])) {
					dp[i] = Math.max(dp[j], dp[i])+1;
				}
			}
			 len = Math.max(len, dp[i]); 
		}
		return (arr.length-len);
	}
	

}
