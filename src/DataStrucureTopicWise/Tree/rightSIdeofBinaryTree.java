package DataStrucureTopicWise.Tree;
import java.util.ArrayList;
//https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-interview-150
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
import java.util.List;

public class rightSIdeofBinaryTree {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 List<Integer> rightside = new ArrayList();
	    
	    public void helper(TreeNode node, int level) {
	        if (level == rightside.size()) 
	            rightside.add(node.val);
	        
	        if (node.right != null) 
	            helper(node.right, level + 1);  
	        if (node.left != null) 
	            helper(node.left, level + 1);
	    }    
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        if (root == null) return rightside;
	        
	        helper(root, 0);
	        return rightside;
	    }

}
