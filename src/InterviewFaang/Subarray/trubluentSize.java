package InterviewFaang.Subarray;
//https://leetcode.com/problems/longest-turbulent-subarray
/*
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.

 

Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * */
public class trubluentSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,4,2,10,7,8,8,1,9};
		System.out.println(maxTurbulenceSize(arr));
	}
	public static int maxTurbulenceSize(int[] arr) {
        int count=1;
        int max=1;
        for(int i=0;i<arr.length;i++){
            if(i>=2 && (arr[i-2]>arr[i-1] && arr[i-1]<arr[i]||arr[i-2]<arr[i-1] && arr[i-1]>arr[i]))
            {
                count++;
            }
            else if(i >= 1 && arr[i - 1] != arr[i]){
                count=2;
            }else{
                count=1;
            }    
              max = Math.max(count,max);
        }
        return max;
    }
	

}
