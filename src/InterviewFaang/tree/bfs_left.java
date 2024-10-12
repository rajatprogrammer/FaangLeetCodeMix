package InterviewFaang.tree;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class bfs_left {
	static class Node {
		int val;
		Node left;
		Node right;
		Node next;

		Node() {
		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = null;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

		public Node connect(Node root) {
			List<Node> nodes = new ArrayList<>();
			dfs(root, 0, nodes);
			return root;
		}

		private void dfs(Node root, int depth, List<Node> nodes) {
			if (null == root)
				return;
			if (depth >= nodes.size())
				nodes.add(root);
			else {
				nodes.get(depth).next = root;
				nodes.set(depth, root);
			}
			dfs(root.left, depth + 1, nodes);
			dfs(root.right, depth + 1, nodes);
		}
	}
}
