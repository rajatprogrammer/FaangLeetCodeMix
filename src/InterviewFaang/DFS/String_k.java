package DFS;
//https://leetcode.com/problems/k-similar-strings/
import java.util.Arrays;

public class String_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String A = "abac";
			String B = "baca";
			String_k ob1 = new String_k();
			System.out.print(ob1.kSimilarity(A,B));
	}
	public int kSimilarity(String A, String B) {
	      return DFS(A.toCharArray(), B.toCharArray(), 0, 0);
	    }
	    
	    public int DFS(char[]  A, char[] B, int i, int count) {
	        int result = Integer.MAX_VALUE;

	        if(i == A.length - 1) {
	            if(Arrays.equals(A, B)) return count;
	            else return result;
	        }
	        
	        if(A[i] == B[i]) return DFS(A, B, i + 1, count);
	        
	        for(int j = i + 1; j < B.length; j++) {
	            // Fixing B to match A, note if same postion char already matches in both than no need to replace it.
	            // Searching for char in B that matches A current index, than replacing postions in B.
	            if(A[i] == B[j] && B[j] != A[j]) {
	                swap(B, i, j); // Let's fix B, we can also fix A by changing above condition to A[j] == B[i]
	                result = Math.min(result, DFS(A, B, i + 1, count + 1));
	                swap(B, i, j);//backtracking
	            }
	        }
	        
	        return result;
	    }
	   
	    public void swap(char[] arr, int i, int j) {
	        char temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

}
