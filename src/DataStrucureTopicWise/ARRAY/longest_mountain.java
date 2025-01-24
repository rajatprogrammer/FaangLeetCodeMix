package DataStrucureTopicWise.ARRAY;

//https://leetcode.com/problems/longest-mountain-in-array/
//google goldmanSach
//twoPointer
public class longest_mountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 1, 4, 7, 3, 2, 5 };
		System.out.print(longestMountain(arr));
	}
	//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	//https://leetcode.com/problems/replace-the-substring-for-balanced-string/
	// o(n) solution
	public static int longestMountain(int[] arr) {
		 int max = 0;
	     for(int i = 1; i < arr.length-1; i++) {
	            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
	            	
	                int left = i-1;
	                int right = i+1;
	                
	                while(left > 0 && arr[left-1] < arr[left]) left--;
	                while(right < arr.length-1 && arr[right] > arr[right+1]) right++;
	                
	                max = Math.max(max, right-left+1);
	            }
	        }
	        return max;
	}

}
