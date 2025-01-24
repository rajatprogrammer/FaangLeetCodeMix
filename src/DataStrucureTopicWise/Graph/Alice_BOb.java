package DataStrucureTopicWise.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
//need to solve with disjoint set below solution is wrong
public class Alice_BOb {
	
	static LinkedList<int[]>adj[];
	public static void main(String[] args) {
		int n=4;
		int edges[][] = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
		System.out.println(maxNumEdgesToRemove(n,edges));
	}
	
	public static int maxNumEdgesToRemove(int n, int[][] edges) {
		adj = new LinkedList[n+1];
		boolean visited[] = new boolean[n+1];
		boolean perRoute[][][] = new boolean[4][n+1][n+1];
		for(int i=0;i<=n;i++) {
			adj[i] = new LinkedList<>();
		}
		for(int row[]:edges) {
			perRoute[row[0]][row[1]][row[2]] = true;
			int[] st = new int[]{row[2],row[0]};
			adj[row[1]].add(st);
		}
		Queue<Integer> q = new LinkedList<>();
		int count[] = new int[3];
		Arrays.fill(count, -1);
		for(int i=1;i<=2;i++) {
			q.add(1);
			Arrays.fill(visited,false);
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i1=0;i1<size;i1++) {
					int data = q.poll();
					if(visited[data]) {
						count[i] = count[i]+1;
						continue;
					}else {
						visited[data]=true;
						for(int[] ac:adj[data]) {
							if(ac[1]==i || ac[1]==3) {
								q.add(ac[0]);
							}
						}
					}
				}
			}	
		}
		return Math.max(count[1], count[2]);
    }

}
