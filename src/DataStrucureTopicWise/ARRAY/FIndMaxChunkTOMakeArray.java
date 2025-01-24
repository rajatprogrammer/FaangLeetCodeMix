package DataStrucureTopicWise.ARRAY;
/*
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 * Input: arr = [4,3,2,1,0]
*Output: 1
*Explanation:
*Splitting into two or more chunks will not return the required result.
*For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

 * */
public class FIndMaxChunkTOMakeArray {

	public static void main(String[] args) {
		int arr[] = {2,1,3,4,4};
		System.out.println(maxChunksToSorted(arr));
		System.out.println(maxChunksToSortedOptimized(arr));

	}
	
	 public static int maxChunksToSorted(int[] arr) {
	     int pprefum = 0; 
	     int indexSUm=0;
	     int count=0;
	     for(int i=0;i<arr.length;i++){
	        pprefum = pprefum + arr[i];
	        indexSUm = indexSUm + i;

	        if(indexSUm==pprefum){
	           count++ ; 
	        }
	     }
	     return count;
	    }
	 
	 public static int maxChunksToSortedOptimized(int[] arr) {
	     int maxSUm = 0; 
	     int count=0;
	     for(int i=0;i<arr.length;i++){
	    	 maxSUm = Math.max(maxSUm, arr[i]);
	        if(maxSUm==i){
	           count++ ; 
	        }
	     }
	     return count;
	    }

}
