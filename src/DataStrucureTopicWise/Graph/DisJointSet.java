package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given a network of n nodes represented as an n x n adjacency matrix graph, where the ith node is directly connected to the jth node if graph[i][j] == 1.

Some nodes initial are initially infected by malware. Whenever two nodes are directly connected, and at least one of those two nodes is infected by malware, both nodes will be infected by malware. This spread of malware will continue until no more nodes can be infected in this manner.

Suppose M(initial) is the final number of nodes infected with malware in the entire network after the spread of malware stops. We will remove exactly one node from initial.

Return the node that, if removed, would minimize M(initial). If multiple nodes could be removed to minimize M(initial), return such a node with the smallest index.

Note that if a node was removed from the initial list of infected nodes, it might still be infected later due to the malware spread.

 

Example 1:

Input: graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
Output: 0
Example 2:

Input: graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
Output: 0
Example 3:

Input: graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
Output: 1
 

Constraints:

n == graph.length
n == graph[i].length
2 <= n <= 300
graph[i][j] is 0 or 1.
graph[i][j] == graph[j][i]
graph[i][i] == 1
1 <= initial.length <= n
0 <= initial[i] <= n - 1
All the integers in initial are unique.

 * 
 * */
public class DisJointSet {
	
	    List<Integer> rank = new ArrayList<>();
	    List<Integer> parent = new ArrayList<>();
	    List<Integer> size = new ArrayList<>(); 
	    
	    public DisJointSet(int n) {
	        for(int i = 0;i<=n;i++) {
	            rank.add(0); 
	            parent.add(i); 
	            size.add(1); 
	        }
	    }
	    
	    public int findUPar(int node) {
	        if(node == parent.get(node)) {
	            return node; 
	        }
	        int ulp = findUPar(parent.get(node)); 
	        parent.set(node, ulp); 
	        return parent.get(node); 
	    }
	    
	    public void unionByRank(int u, int v) {
	        int ulp_u = findUPar(u); 
	        int ulp_v = findUPar(v); 
	        if(ulp_u == ulp_v) return; 
	        if(rank.get(ulp_u) < rank.get(ulp_v)) {
	            parent.set(ulp_u, ulp_v); 
	        }
	        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
	            parent.set(ulp_v, ulp_u); 
	        }
	        else {
	            parent.set(ulp_v, ulp_u); 
	            int rankU = rank.get(ulp_u); 
	            rank.set(ulp_u, rankU + 1); 
	        }
	    }
	    
	    public void unionBySize(int u, int v) {
	        int ulp_u = findUPar(u); 
	        int ulp_v = findUPar(v); 
	        if(ulp_u == ulp_v) return; 
	        if(size.get(ulp_u) < size.get(ulp_v)) {
	            parent.set(ulp_u, ulp_v); 
	            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
	        }
	        else {
	            parent.set(ulp_v, ulp_u); 
	            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
	        }
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisJointSet ds = new DisJointSet(7);
	        ds.unionByRank(1, 2); 
	        ds.unionByRank(2, 3); 
	        ds.unionByRank(4, 5); 
	        ds.unionByRank(6, 7); 
	        ds.unionByRank(5, 6); 
	        
	        // if 3 and 7 same or not 
	        if(ds.findUPar(3) == ds.findUPar(7)) {
	            System.out.println("Same"); 
	        }
	        else 
	            System.out.println("Not Same"); 
	            
	        ds.unionByRank(3, 7); 
	        if(ds.findUPar(3) == ds.findUPar(7)) {
	            System.out.println("Same"); 
	        }
	        else 
	            System.out.println("Not Same"); 
	    }
	}
