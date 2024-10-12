package DataStrucureTopicWise.Tree;
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class Greater_sum_tree {
	class Solution {
	    private int sum = 0;
	    
	    public TreeNode bstToGst(TreeNode root) {  
	        if (root != null) {
	            bstToGst(root.right); 
	            sum += root.val;  
	            root.val = sum; 
	            bstToGst(root.left);
	        }
	        return root;
	    }
	}
}
