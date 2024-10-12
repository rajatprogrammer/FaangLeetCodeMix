package DP;
//https://www.geeksforgeeks.org/partition-problem-dp-18/
public class parition_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3, 1, 1, 2, 2, 1};
		System.out.println(findPartition(arr,arr.length));
	}
	static boolean isSubsetSum(int arr[], int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than sum, then ignore
		// it
		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum);

		/* else, check if sum can be obtained by any of
		the following
		(a) including the last element
		(b) excluding the last element
		*/
		return isSubsetSum(arr, n - 1, sum)
			|| isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	}

	// Returns true if arr[] can be partitioned in two
	// subsets of equal sum, otherwise false
	static boolean findPartition(int arr[], int n)
	{
		// Calculate sum of the elements in array
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		// If sum is odd, there cannot be two subsets
		// with equal sum
		if (sum % 2 != 0)
			return false;

		// Find if there is subset with sum equal to half
		// of total sum
		return isSubsetSum(arr, n, sum / 2);
	}


}
