package DataStrucureTopicWise.Tree;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class flatttenbinaryTreetolinklist {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			val=data;
			left=right=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private TreeNode flattenTree(TreeNode node) {
        // Handle the null scenario
        if (node == null) {
            return null;
        }

        // For a leaf node, we simply return the
        // node as is.
        if (node.left == null && node.right == null) {
            return node;
        }

        //Recursively flatten the left subtree
        TreeNode leftTail = this.flattenTree(node.left);

        // Recursively flatten the right subtree
        TreeNode rightTail = this.flattenTree(node.right);

        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // We need to return the "rightmost" node after we are
        // done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }

}
