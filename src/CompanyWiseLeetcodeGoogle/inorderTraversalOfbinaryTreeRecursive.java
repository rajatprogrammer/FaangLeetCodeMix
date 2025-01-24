package CompanyWiseLeetcodeGoogle;

import java.util.Stack;
//inorder traversal of bianry tree iterative
public class inorderTraversalOfbinaryTreeRecursive {

	class TreeNode {
	    int value;
	    TreeNode left, right;

	    public TreeNode(int value) {
	        this.value = value;
	        left = right = null;
	    }
	}
	
	public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current is now null; process the top node in the stack
            current = stack.pop();
            System.out.print(current.value + " ");

            // Move to the right subtree
            current = current.right;
        }
    }
	
}
