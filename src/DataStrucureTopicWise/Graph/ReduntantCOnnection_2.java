package DataStrucureTopicWise.Graph;

import java.util.Arrays;


/*
 * https://leetcode.com/problems/redundant-connection-ii/description/
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]
 * 
 * */
public class ReduntantCOnnection_2 {
	
	class DisjointSet{
	    int[] parent, size;

	    public DisjointSet(int n){
	        parent = new int[n];
	        size = new int[n];
	        for(int i=0;i<n;i++){
	            parent[i] = i;
	            size[i] = 1;
	        }
	    }

	    int find(int u){
	        if(parent[u] != u)
	            parent[u] = find(parent[u]);
	        return parent[u];
	    }

	    boolean union(int u, int v){
	        int pu = find(u);
	        int pv = find(v);

	        if(pu == pv)
	            return true;
	        if(size[pu] > size[pv]){
	            parent[pv] = pu;
	            size[pu]+=size[pv];
	        }else{
	            parent[pu] = pv;
	            size[pv]+=size[pu];
	        }
	        return false;
	    }

	}

	

	public static void main(String[] args) {
		ReduntantCOnnection_2 ob1 = new ReduntantCOnnection_2();
		int edge[][] = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		int arr[]=ob1.findRedundantDirectedConnection(edge);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public int[] findRedundantDirectedConnection(int[][] edges) {
		
		//need to check cyclic edge and the conflicting edge and to check the edgeConnection 
		
        int n = edges.length;
        //create a parent array of size n+1 since there are 1-n edges.
        int[] parent = new int[n+1];
        //initialising every node as it's own parent
        for(int i=0;i<=n;i++)
            parent[i] = i;

        //initialising conflict edge and cycle edge
        int conflictEdge = -1, cycleEdge = -1;
        DisjointSet ds = new DisjointSet(n+1);

        for(int i=0;i<n;i++){

            int from = edges[i][0], to = edges[i][1];

            //if it is a conflicting edge
            if(parent[to] != to){
                conflictEdge = i;
            }else{
                //not a conflicting edge
                parent[to] = from;
                //true if it is a cycle else false;
                if(ds.union(from, to)){
                    cycleEdge = i;
                }
            }
        }

        //if only conflicting edge exist return it
        if(cycleEdge == -1){
            return edges[conflictEdge];
        }
        //if only cycle exist 
        if(conflictEdge == -1)
            return edges[cycleEdge];

        //if both  exist
        int to = edges[conflictEdge][1];
        return new int[]{parent[to], to};
    }
}