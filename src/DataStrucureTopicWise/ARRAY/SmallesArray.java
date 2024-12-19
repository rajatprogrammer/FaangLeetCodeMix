package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

//https://leetcode.com/problems/smallest-range-ii/description/?envType=company&envId=adobe&favoriteSlug=adobe-six-months
public class SmallesArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
		int n=A.length;
		int res=A[n-1]-A[0];

		for(int i=0;i<n-1;i++){
			int max=Math.max(A[n-1]-K,A[i]+K);
			int min=Math.min(A[0]+K,A[i+1]-K);
			res=Math.min(res,max-min);
		}

		return res;

    }


}
