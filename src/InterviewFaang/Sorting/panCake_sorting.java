package InterviewFaang.Sorting;
//https://leetcode.com/problems/pancake-sorting/
//https://leetcode.com/problems/spiral-matrix-ii/
//https://leetcode.com/problems/advantage-shuffle/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class panCake_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,2,4,1};
		panCake_sorting ob1= new panCake_sorting();
		System.out.print((Arrays.toString(ob1.pancakeSort(arr).stream().toArray())));
	}
	public List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        if(A==null || A.length==0 || isArraySorted(A))
            return flips;
        
        for(int i=0;i<A.length;i++) {
            int maxIndex = findMaxIndex(A, 0, A.length-i-1);
            //no point in flipping only the first element
            if(maxIndex!=0) { 
            reverse(A, 0, maxIndex); //flip until the max Element
            flips.add(maxIndex+1); //add that flip to output
            }
            reverse(A, 0, A.length-i-1); //take the element to the last
            flips.add(A.length-i); // add that flip
            if(isArraySorted(A))//at any point if the array is sorted ret
                return flips;
        }
        return flips;
    }
    
    //check if array is sorted or not
    private boolean isArraySorted(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
    
    //find the index of max element in an array.
    private int findMaxIndex(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=start;i<=end;i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    
    //reverse the array from start to end indexes
    private void reverse(int[] arr, int start, int end) {
       while(start<end) {
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }
    }

}
