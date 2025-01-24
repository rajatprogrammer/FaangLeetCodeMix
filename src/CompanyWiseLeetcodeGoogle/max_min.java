package CompanyWiseLeetcodeGoogle;
//https://leetcode.com/problems/best-sightseeing-pair/description
/*
 * Best Sightseeing Pair
Hint
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots
 * */
public class max_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	     public int maxScoreSightseeingPair(int[] values){
	        int n = values.length;
	        int res = Integer.MIN_VALUE;
	        int maxLeft = values[0]; // value[i] + i
	        
	        for(int i = 1; i < n; i++){
	            res = Math.max(res, maxLeft + values[i] - i);
	            maxLeft = Math.max(maxLeft, (values[i] + i));
	        }
	        return res; 
	    }

}
