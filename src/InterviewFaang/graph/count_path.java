package graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/
//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
public class count_path {
	static class graph {
		int E;
		List<Integer> V[];

		public graph(int E) {
			this.E = E;
			V = new List[E + 1];
			for (int i = 0; i <= E; i++) {
				V[i] = new ArrayList<Integer>();
			}
		}
	}

	graph root;
	List<List<Integer>> outp = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { { 1, 2 }, { 3 }, { 3 }, {} };
		count_path ob1 = new count_path();
		// ob1.allPathsSourceTargetRajat(graph);
		ob1.allPathsSourceTarget(graph);
	}

	public List<List<Integer>> allPathsSourceTargetRajat(int[][] graph) {
		create_graph(graph);
		int start = 0;
		int end = root.E;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(start);
		dfs(start, end, temp, 0);
		return outp;

	}

	public void create_graph(int[][] graph) {
		int E = graph.length - 1;
		root = new graph(E);
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				root.V[i].add(graph[i][j]);
			}
		}
	}

	public void dfs(int start, int end, List<Integer> list, int i) {
		for (int itr = 0; itr < root.V[start].size(); itr++) {
			System.out.println(itr + "itr");
			start = root.V[start].get(itr);
			list.add(start);
			if (start == end) {
				outp.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
				return;
			}
			dfs(start, end, list, itr);
			start = list.remove(list.size() - 1);
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		recurse(graph, path, result, 0);
		return result;
	}

	public void recurse(int[][] graph, List<Integer> path, List<List<Integer>> result, int idx) {
		if (idx == graph.length - 1) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < graph[idx].length; i++) {
			List<Integer> temp = new ArrayList<>(path);
			temp.add(graph[idx][i]);
			recurse(graph, temp, result, graph[idx][i]);
		}
	}

}
