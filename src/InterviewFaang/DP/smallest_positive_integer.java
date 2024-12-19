package InterviewFaang.DP;
//https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/?ref=rp

import java.util.ArrayList;
import java.util.List;

public class smallest_positive_integer {
	List<Integer> res=new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		smallest_positive_integer ob1 =new smallest_positive_integer();
		int arr[] = {1, 1, 3, 4};
		ob1.findSmallest(arr,arr.length);
		
	}
	int findSmallest(int arr[], int n) 
	{ 
		int res = 1; // Initialize result 

		// Traverse the array and increment 'res' if arr[i] is 
		// smaller than or equal to 'res'. 
		for (int i = 0; i < n && arr[i] <= res; i++) 
			res = res + arr[i]; 

		return res; 
	} 

}
