package InterviewFaang.DP;

import java.util.Arrays;
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class longest_increasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		  System.out.print("Length of LIS is "
                  + lengthOfLIS(arr));
		  System.out.print("Length of LIS is "
                  + LIS(arr,0,arr.length,Integer.MIN_VALUE));
	}
	
	public static int lengthOfLIS(int[] A) {
        if(A.length<=0){
            return 0;
        }
      int[] L = new int[A.length];
 
        // longest increasing sub-sequence ending with A[0] has length 1
        L[0] = 1;
 
        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in sub-array A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest increasing sub-sequence that ends with A[j]
                // where A[j] is less than the current element A[i]
                if (A[j] < A[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }
            // include A[i] in LIS
            L[i]++;
        }
 
        // return longest increasing sub-sequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }
	
	public static  int LIS(int[] A, int i, int n, int prev)
    {
        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = LIS(A, i + 1, n, prev);
 
        // case 2: include the current element if it is greater
        // than previous element in LIS
        int incl = 0;
        if (A[i] > prev) {
            incl = 1 + LIS(A, i + 1, n, A[i]);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }

}
