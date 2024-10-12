package Array;
/*Find the smallest positive number missing from an unsorted array | Set 1
Difficulty Level : Hard
//amazon
 Last Updated : 03 Dec, 2020
You are given an unsorted array with both positive and negative elements. You have to find the smallest positive number missing from the array in O(n) time using constant extra space. You can modify the original array.

Examples 

 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2
 * */
public class findmissingPoitive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {0, 10, 2, -10, -20 };
		System.out.print(solution(A));
	}
	static int solution(int[] A)
    {
        int n = A.length;
 
        // To mark the occurrence of elements
        boolean[] present = new boolean[n + 1];
 
        // Mark the occurrences
        for (int i = 0; i < n; i++) {
 
            // Only mark the required elements
            // All non-positive elements and
            // the elements greater n + 1 will never
            // be the answer
            // For example, the array will be {1, 2, 3}
            // in the worst case and the result
            // will be 4 which is n + 1
            if (A[i] > 0 && A[i] <= n)
                present[A[i]] = true;
        }
 
        // Find the first element which didn't
        // appear in the original array
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;
 
        // If the original array was of the
        // type {1, 2, 3} in its sorted form
        return n + 1;
    }
 

}
