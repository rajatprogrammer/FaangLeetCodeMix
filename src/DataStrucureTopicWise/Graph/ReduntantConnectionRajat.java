package DataStrucureTopicWise.Graph;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/redundant-connection/
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

	You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

	Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
	
	In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 * 
 * */
public class ReduntantConnectionRajat {
	
	class DSU
	{
		
		int n;
		int size[];
		int parent[];
		
		public DSU(int n) {
			this.n = n;
			this.size = new int[n];
			for(int i=0;i<n;i++) {
				size[i] = 1;
			}
			this.parent = new int[n];
			for(int i=0;i<n;i++) {
				parent[i]=i;
			}
		}
		
		public int findParent(int x) {
			if(x==parent[x]) {
				return x;
			}else {
				return parent[x] = findParent(parent[x]);
			}
		}
		
		public boolean union(int u,int v) {
			int p_u = findParent(u);
			int p_v = findParent(v);	
			if(p_u==p_v) {
				return false;
			}else {
				if(size[p_v]>size[p_u]) {
					size[p_v] = size[p_v]+size[p_u];
					parent[p_u] = p_v;
				}else {
					size[p_u] = size[p_v]+size[p_u];
					parent[p_v] = p_u;
				}
				return true;
			}
		}
		
	}
	
	 public int[] findRedundantConnection(int[][] edges) {
	        int N = edges.length;
	        DSU ob1 = new DSU(N);
	        int result[] = new int[2];
	        
	       for(int itr[]:edges) {
	    	   int u = itr[0]-1;
	    	   int v = itr[1]-1;
	    	   
	    	   if(!ob1.union(u,v)) {
	    		   result[0] = itr[0];
	    		   result[1] = itr[1];
	    		   return result;
	    	   }
	       }
	       return result; 
	 }
	

	public static void main(String[] args) {
		ReduntantConnectionRajat ob2= new ReduntantConnectionRajat();
		int arr[][] = {{1,2},{1,3},{2,3}};
		System.out.println(Arrays.toString(ob2.findRedundantConnection(arr)));

	}
	
	
	
	
	
	
	

}
