package PracticeGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BfsGraph {
	
	int V;
	LinkedList<Integer> adjList[];
	HashSet<Integer> visited;
	Queue<Integer>queue;
	
	public BfsGraph(int V) {
		this.V  = V;
		adjList = new LinkedList[V];
		for(int i=0;i<V;i++) {
			adjList[i] = new LinkedList<>();
		}
		visited = new HashSet<>();
	}
	
	public void addEdge(int source,int dest) {
		adjList[source].add(dest);
	}
	
	public void bfs(int source) {
		queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);
		while(!queue.isEmpty()) {
			int pop = queue.poll();
			System.out.print("->"+pop);
			for(int x :  adjList[pop]) {
				if(!visited.contains(x)) {
					queue.add(x);
					visited.add(x);
				}
			}
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BfsGraph bp = new BfsGraph(4);
		bp.addEdge(0, 1);
		bp.addEdge(0, 2);
		bp.addEdge(1, 2);
		bp.addEdge(2, 0);
		bp.addEdge(2, 3);
		bp.addEdge(3, 3);
		
		//bp.bfs(0);
		System.out.println("\n");
		//bp.bfs(1);
		System.out.println("\n");
		bp.bfs(2);
	}
	

}
