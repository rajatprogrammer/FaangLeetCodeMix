package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/minimum-height-trees
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:

 * 
 * */
public class MinimumHeightTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int edge[][] = {{1,0},{1,2},{1,3}};
		System.out.println(findMinHeightTrees(n,edge).toString());
	}
	
	 public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        if (n == 1) return Collections.singletonList(0);
	        
	        int[] degree = new int[n];
	        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
	        for (int[] edge : edges) {
	            degree[edge[0]]++;
	            degree[edge[1]]++;
	            adjacencyList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
	            adjacencyList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
	        }

	        Queue<Integer> leaves = new LinkedList<>();
	        for (int i = 0; i < degree.length; i++) {
	            if (degree[i] == 1) {
	                leaves.add(i);
	            }
	        }

	        int remainingNodes = n;
	        while (remainingNodes > 2) {
	            int size = leaves.size();
	            remainingNodes -= size;
	            for (int i = 0; i < size; i++) {
	                int leaf = leaves.poll();
	                for (int neighbor : adjacencyList.get(leaf)) {
	                    if (--degree[neighbor] == 1) {
	                        leaves.add(neighbor);
	                    }
	                }
	            }
	        }

	        return new ArrayList<>(leaves);
	    }

}
