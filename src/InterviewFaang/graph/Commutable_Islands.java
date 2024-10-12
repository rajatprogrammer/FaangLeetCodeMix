package graph;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/commutable-islands/
/*There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Input Format:

The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3:
    => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
    Input 1:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 4]
            [1, 4, 3]
            [4, 3, 2]
            [1, 3, 10]  ]

Output 1:
    6

Explanation 1:
    We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Input 2:
    A = 4
    B = [   [1, 2, 1]
            [2, 3, 2]
            [3, 4, 4]
            [1, 4, 3]   ]

Output 2:
    6

Explanation 2:
    We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 NOTE: You only need to implement the given function. Do not read input, instead use the 
 * */

public class Commutable_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 4;
		int[][] B = { { 1, 2, 1 }, { 2, 3, 4 }, { 1, 4, 3 }, { 4, 3, 2 }, { 1, 3, 10 } };

	}

	public class UF {
		int N;
		int[] parent;

		UF(int n) {
			this.N = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}

		}

		public boolean Find(int i, int j) {
			if (parent[i] == parent[j])
				return true;
			else
				return false;
		}

		public void Union(int i, int j) {
			if (Find(i, j))
				return;
			int changeThis = parent[i];
			for (int v = 0; v < N; v++) {
				if (parent[v] == changeThis)
					parent[v] = parent[j];
			}
		}

	}

	public class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		Edge(int u, int v, int w) {
			this.s = u;
			this.e = v;
			this.w = w;
		}

		public int compareTo(Edge that) {
			return this.w - that.w;
		}

		public String toString() {
			return "" + s + " to " + e + " weight " + w;
		}

	}

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {

		UF u = new UF(A);
		ArrayList<Edge> eList = new ArrayList<Edge>();
		for (int i = 0; i < B.size(); i++)
			eList.add(new Edge(B.get(i).get(0) - 1, B.get(i).get(1) - 1, 0 + B.get(i).get(2)));
		Collections.sort(eList);
		// System.out.println(eList);
		int ans = 0;
		for (int i = 0; i < eList.size(); i++) {
			if (!u.Find(eList.get(i).s, eList.get(i).e)) {
				u.Union(eList.get(i).s, eList.get(i).e);
				ans += eList.get(i).w;
			}
		}

		return ans;

	}

}
