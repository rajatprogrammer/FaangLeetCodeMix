package InterviewFaang.DP;

import java.util.Arrays;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		int W=50;
		System.out.println(recursiveSol(val,weight,weight.length,W));
		System.out.println(dpSol(val,weight,weight.length,W));
	}
	
	public static int recursiveSol(int val[],int weight[],int i,int W ) {
			if(W==0 || i==0 ) {
				return 0;
			}else {
				if(weight[i-1]>W) {
					return recursiveSol(val,weight,i-1,W);
				}else {
					int rec1 = val[i-1]+recursiveSol(val,weight,i-1,W-weight[i-1]);
					int rec2 = recursiveSol(val,weight,i-1,W);
					return Math.max(rec1, rec2);
				}
			}
	}
	public static int dpSol(int val[],int wt[],int n,int W) {
		int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++)  
        { 
            for (w = 0; w <= W; w++)  
            { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] 
                        = Math.max(val[i - 1] 
                         + K[i - 1][w - wt[i - 1]], 
                         K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
		for(int l=0;l<K.length;l++) {
			System.out.println(Arrays.toString(K[l]));
		}
		int starti=n;
		int end=W;
		while(starti>=0 && end>=0) {
			if(K[starti][end]==0 ) {
				System.out.print("->"+val[starti-1]);
				break;
			}
			if(end-1>=0 && starti-1>=0) {
				if(K[starti][end]==K[starti-1][end]) {
					starti=starti-1;
				}else if(K[starti][end]==K[starti][end-1]) {
					end=end-1;
				}else {
					System.out.print("->"+val[starti-1]);
					starti=starti-1;
					end=end-wt[starti];
				}
			}
		}
		System.out.println("choosen weight");
		return K[n][W];
	}
	

}
