package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * uber interview
 * There is a HCV 
 * h1 = [1,5,7][3,6,7]
 * source = 1 ,dest = 6;
 * output=1 (because 1 route is changed from row 0 to row 1)
 * h1 = [[1,5,7],[3,5,6],[9,7,5]]
 * output = 2 ((because 1 route is changed from row 0 to row 1 and from row 1 to row 2)
 *  source = 1 ,dest = 9;
 * */
public class BusRoute_2 {

	public HashMap<Integer,List<Integer>> adj ;
	
	public BusRoute_2(int mat[][]) {
		adj = new HashMap<>();
		for(int i=0;i<mat.length;i++) {
			for(int x:mat[i]) {
				if(adj.containsKey(x)) {
					List<Integer> lp = adj.get(x);
					lp.add(i);
					adj.put(x,lp);
				}else {
					List<Integer> lp = new ArrayList<Integer>();
					lp.add(i);
					adj.put(x,lp);
				}
			}
		}
	}
	
	public int minimumBusChange(int mat[][],int source,int dest) {
		boolean visitedRoutes[]=new boolean[mat.length];
		if(source==dest) {
			return 0;
		}else if(!adj.containsKey(source)|| !adj.containsKey(dest)) {
			return 0;
		}
		else {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(source);
			int count=0;
			while(!q.isEmpty()) {
				for(int i=0;i<q.size();i++) {
					int tempSource = q.poll();
					for(int row:adj.get(tempSource)) {
						if(visitedRoutes[row]) {
							continue;
						}else {
							visitedRoutes[row] = true;
							for(int val:mat[row]) {
								if(val == dest) {
									return count;
								}
								q.add(val);
							}
							count++;
						}
					}
				}
			}
		}
		
		return -1;
		
	}
	public static void main(String[] args) {
		
		int mat[][] = {{1,2,65},{3,6,7},{4,9,7}};
		BusRoute_2 ob1 = new BusRoute_2(mat);
		System.out.println(ob1.minimumBusChange(mat, 1,3));

	}
	/*Time complexity:- O[m*n];
	 * */
	

}
