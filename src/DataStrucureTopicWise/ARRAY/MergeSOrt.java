package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

//mergeSOrt
public class MergeSOrt {
	
	public static void main(String[] args) {
        int[] array = {3, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original Array: " + Arrays.toString(array));
        
        mergeSort(array);
        
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Merge Sort function
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted if it has one element
        }
        
        int mid = array.length / 2; // Find the middle index
        int[] left = Arrays.copyOfRange(array, 0, mid); // Left half
        int[] right = Arrays.copyOfRange(array, mid, array.length); // Right half

        mergeSort(left);  // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half
        
        merge(array, left, right); // Merge the sorted halves
    }

    // Merge function to combine two sorted subarrays into one sorted array
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merge the left and right arrays into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Copy the remaining elements of left array if any
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        // Copy the remaining elements of right array if any
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

}
