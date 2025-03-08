package DataStrucureTopicWise.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 *https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * */
public class ShortestPathVisitingNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class State {
	    int node;
	    int steps;
	    Set<Integer> visited;

	    State(int node, int steps, Set<Integer> visited) {
	        this.node = node;
	        this.steps = steps;
	        this.visited = new HashSet<>(visited);
	    }
	}
	
	public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        Map<Integer, Set<Set<Integer>>> visitedStates = new HashMap<>();
        Queue<State> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> initialVisited = new HashSet<>();
            initialVisited.add(i);
            visitedStates.put(i, new HashSet<>(Arrays.asList(initialVisited)));
            queue.add(new State(i, 0, initialVisited));
        }

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int node = currentState.node;
            int steps = currentState.steps;
            Set<Integer> visited = currentState.visited;

            if (visited.size() == n)
                return steps;

            for (int adjNode : graph[node]) {
                Set<Integer> newVisited = new HashSet<>(visited);
                newVisited.add(adjNode);

                if (!visitedStates.get(adjNode).contains(newVisited)) {
                    queue.add(new State(adjNode, steps + 1, newVisited));
                    visitedStates.computeIfAbsent(adjNode, k -> new HashSet<>()).add(newVisited);
                }
            }
        }

        return -1;
    }

}
