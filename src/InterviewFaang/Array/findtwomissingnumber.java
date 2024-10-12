package Array;
/*
 * https://www.geeksforgeeks.org/find-two-missing-numbers-set-1-an-interesting-linear-time-solution/
 * Given an array of n unique integers where each element in the array is in range [1, n]. The array has all distinct elements and size of array is (n-2). Hence Two numbers from the range are missing from this array. Find the two missing numbers.

Examples :

Input  : arr[] = {1, 3, 5, 6}
Output : 2 4

Input : arr[] = {1, 2, 4}
Output : 3 5

Input : arr[] = {1, 2}
Output : 3 4
 * 
 * */
public class findtwomissingnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 6};
		int n=6;
	
		twomissing(arr,n);
	}
	
	public static void twomissing(int arr[],int n) {
		int totalSum = 0;
		int ApSum = n*(n+1)/2;
		for(int i=0;i<arr.length;i++) {
			totalSum = totalSum + arr[i];
		}
		
		int TwoNumberSum = ApSum-totalSum;
		
		int Avg = TwoNumberSum/2;
		
		int ApSumOfAvg = Avg * (Avg+1)/2;
		
		int smallerSum = 0;
		int i=0;
		while(arr[i]<=Avg) {
			smallerSum = smallerSum + arr[i];
			i++;
		}
		int firstNum = (ApSumOfAvg-smallerSum);
		System.out.println("first Number is"+ firstNum);
		
		System.out.print("Second Number is" + (ApSum-firstNum-totalSum));
		
	}

}
