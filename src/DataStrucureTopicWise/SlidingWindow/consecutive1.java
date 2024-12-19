package DataStrucureTopicWise.SlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii
public class consecutive1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
		int k=2;
		System.out.println(longestOnes(nums,k));
	}
	
	public static int longestOnes(int[] A, int K) {
        int result = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < A.length) {
            if (A[endIdx] == 0) {
                K--;
            }
			//shrink the window if we run out of K
            while (K < 0 && startIdx < endIdx) {
                if (A[startIdx] == 0) {
                    K++;
                }
                startIdx++;
            }
            if (startIdx < endIdx || A[endIdx] != 0) {  //skip if startIdx == endIdx and A[endIdx] is a 0
                result = Math.max(result, endIdx - startIdx + 1);
            }
            endIdx++;
        }
        return result;
    }

}
