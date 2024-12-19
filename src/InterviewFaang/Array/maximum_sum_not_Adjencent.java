package InterviewFaang.Array;
//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class maximum_sum_not_Adjencent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,20,5,-100,400};
		System.out.print(FindMaxSum(arr,arr.length));
	}
    static int FindMaxSum(int arr[], int n) 
	{ 
		int incl = arr[0]; 
		int excl = 0; 
		int excl_new; 
		int i; 

		for (i = 1; i < n; i++) 
		{ 
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl; 

			/* current max including i */
			incl = excl + arr[i]; 
			excl = excl_new; 
		} 

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl); 
	} 
	

}
