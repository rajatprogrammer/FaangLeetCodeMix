package DataStrucureTopicWise.Graph;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
 * 
 * */
public class FLowerPlantingWIthNoAdjustent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] gardenNoAdj(int n, int[][] paths) {
        //build the graph
        ArrayList<ArrayList<Integer>> al =new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] path:paths){
            int a = path[0]-1;
            int b =path[1]-1;
            al.get(a).add(b);
            al.get(b).add(a);
        }
        int [] marked = new int[n];
        for(int i=0;i<n;i++){ // loop through each garden and get what colors 
            int []used = new int[5];//check what other gardens are been flowered
            for(int node:al.get(i)){
                if(marked[node]!=0){
                    used[marked[node]]=1;
                }
            }
            for(int col=1;col<=4;col++){//assign the nearest unflowered type
                if(used[col]==0){
                    marked[i]=col;
                    break;
                }
            }
        }
        return marked;
    }

}
