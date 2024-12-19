package InterviewFaang.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class diagonal_traversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
		solve(root);
	}

	public static ArrayList<Integer> solve(TreeNode A) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		if (A == null)
			return res;
		pre(A, map, 0);
		for (int i = 0; i < map.size(); i++) {
			res.addAll(map.get(i));
		}
		return res;
	}

	public static void pre(TreeNode node, Map<Integer, ArrayList<Integer>> map, int level) {
		if (node == null)
			return;
		map.putIfAbsent(level, new ArrayList<>());
		map.get(level).add(node.val);
		pre(node.left, map, level + 1);
		pre(node.right, map, level);
	}

}
