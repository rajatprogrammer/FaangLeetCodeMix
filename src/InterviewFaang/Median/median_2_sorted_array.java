package Median;
//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class median_2_sorted_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		     int ar1[] = { 1, 2, 3, 6 }; 
	        int ar2[] = { 4, 6, 8, 10 }; 
	        int n1 = ar1.length; 
	        int n2 = ar2.length; 
	        System.out.print(getMedian(ar1,ar2,0,0,n1-1,n2-1));
	}
	static int getMedian( 
	        int[] a, int[] b, int startA, 
	        int startB, int endA, int endB) 
	    { 
	        if (endA - startA == 1) { 
	            return ( 
	                       Math.max(a[startA], 
	                                b[startB]) 
	                       + Math.min(a[endA], b[endB])) 
	                / 2; 
	        } 
	        /* get the median of 
	    the first array */
	        int m1 = median(a, startA, endA); 
	  
	        /* get the median of 
	    the second array */
	        int m2 = median(b, startB, endB); 
	  
	        /* If medians are equal then 
	    return either m1 or m2 */
	        if (m1 == m2) { 
	            return m1; 
	        } 
	  
	        /* if m1 < m2 then median must 
	    exist in ar1[m1....] and 
	                ar2[....m2] */
	        else if (m1 < m2) { 
	            return getMedian( 
	                a, b, (endA + startA + 1) / 2, 
	                startB, endA, 
	                (endB + startB + 1) / 2); 
	        } 
	  
	        /* if m1 > m2 then median must 
	    exist in ar1[....m1] and 
	    ar2[m2...] */
	        else { 
	            return getMedian( 
	                a, b, startA, 
	                (endB + startB + 1) / 2, 
	                (endA + startA + 1) / 2, endB); 
	        } 
	    } 
	/* Function to get median 
    of a sorted array */
    static int median( 
        int[] arr, int start, int end) 
    { 
        int n = end - start + 1; 
        if (n % 2 == 0) { 
            return ( 
                       arr[start + (n / 2)] 
                       + arr[start + (n / 2 - 1)]) 
                / 2; 
        } 
        else { 
            return arr[start + n / 2]; 
        } 
    } 
    //way2
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int [] extra = new int[m+n];
        int i=0,j=0,k=0;
        while(i<n||j<m){
            if(i!=n&&j!=m){
                if(nums1[i]<=nums2[j]){
                    extra[k]=nums1[i];
                    k++;
                    i++;
                }
                else{
                    extra[k]=nums2[j];
                    k++;
                    j++;
                }
            }
            else{
                if(i<n){
                    extra[k]=nums1[i];
                    k++;
                    i++;
                }
                if(j<m){
                    extra[k]=nums2[j];
                    k++;
                    j++;
                }
        }
        }
          
        double median=0;
            
        if(extra.length%2==0){
             
            median = (double)((extra[extra.length/2])+(extra[(extra.length/2)-1]))/2;
            return median;
        }
        else{
            median=(double)extra[extra.length/2];
            return median;
        }
    }


}
