package InterviewFaang.tree;

//Find distance between two nodes of a Binary Tree
//https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
public class distance_2_node {
	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		distance_2_node ob1 = new distance_2_node();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		Node lca = ob1.LCA(root, 5, 8);
		int d1 = ob1.findLevel(lca, 5, 0);
		int d2 = ob1.findLevel(lca, 8, 0);
		System.out.print("level" + "" + (d1 + d2));
	}

	public Node LCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.value == n1 || root.value == n2) {
			return root;
		}
		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		return right;
	}

	public int findLevel(Node root, int n, int level) {
		if (root == null)
			return -1;
		if (root.value == n)
			return level;
		int left = findLevel(root.left, n, level + 1);
		if (left == -1)
			return findLevel(root.right, n, level + 1);
		return left;
	}

}
