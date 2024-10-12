package tree;
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
import java.util.HashMap;

public class construct_inorder_postorder {
	HashMap<Integer, Integer> map;
	int i;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		construct_inorder_postorder ob1 = new construct_inorder_postorder();
		int inorder[] = {9,3,15,20,7};
		int postorder[] = {9,15,7,20,3};
		ob1.buildTree(inorder, postorder);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		map = new HashMap<>();
		for (i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, postorder, 0, postorder.length - 1);
	}

	private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
		if (start > end) {
			return null;
		}

		--i;
		TreeNode root = new TreeNode(postorder[i]);
		int index = map.get(postorder[i]);

		root.right = helper(inorder, postorder, index + 1, end);
		root.left = helper(inorder, postorder, start, index - 1);

		return root;
	}

}
