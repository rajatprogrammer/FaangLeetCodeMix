package InterviewFaang.heap;
//https://www.geeksforgeeks.org/heap-sort/
import java.util.Arrays;

public class heap_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 11, 13, 5, 6, 7}; 
        int n = arr.length; 
        heap_sort ob = new heap_sort(); 
        ob.sort(arr); 
        System.out.print(Arrays.toString(arr));
	}
	public void sort(int arr[]) {
		for(int i=arr.length/2-1;i>=0;i--) {
			heapify(arr,i,arr.length);
		}
		// One by one extract an element from heap 
        for (int i=arr.length-1; i>0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr,0,i); 
        } 
	}
	public void heapify(int arr[],int pos,int n) {
		int largest=pos;
		int l=2*pos+1;
		int r=2*pos+2;
		if(l < n && arr[largest]<arr[l]) {
			largest=l;	
		}
		if(r<n && arr[largest]<arr[r]) {
			largest=r;	
		}
		if(largest!=pos) {
			  int swap = arr[pos]; 
	            arr[pos] = arr[largest]; 
	            arr[largest] = swap; 
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
		}
	}

}
