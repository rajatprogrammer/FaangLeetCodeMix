package InterviewFaang.heap;

import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
public class minimumrope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {1,2,3,2};
		int n=4;
		System.out.print(minCost(arr,n));
	}
	static long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        long total=0;
        while(pq.size()>1){
         long f=pq.poll()+pq.poll();
         total=total+f;
            pq.add(f);
        }
        return total;
    }

}
