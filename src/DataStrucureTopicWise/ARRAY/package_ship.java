package DataStrucureTopicWise.ARRAY;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//https://www.geeksforgeeks.org/find-two-rectangles-overlap/
public class package_ship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.print(shipWithinDays(arr,5));
	}
	static int shipWithinDays(int[] weights, int D) {
		int toalLoad = 0, maxLoad=Integer.MIN_VALUE;
		for(int weight:weights) {
			toalLoad = toalLoad + weight;
			maxLoad = Math.max(maxLoad,weight);
		}
		int l = maxLoad , r = toalLoad;
		while(l<r) {
			int mid = (l+r)/2;
			if(feasible(weights,mid,D)) {
				r = mid;
			}else {
				l = mid +1;
			}
		}
		return l;
    }
	
	 static Boolean feasible(int[] weights, int c, int days) {
	        int daysNeeded = 1, currentLoad = 0;
	        for (int weight : weights) {
	            currentLoad += weight;
	            if (currentLoad > c) {
	                daysNeeded++;
	                currentLoad = weight;
	            }
	        }

	        return daysNeeded <= days;
	    }
	
	 
}
