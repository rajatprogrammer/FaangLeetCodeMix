package CompanyWiseLeetcode.sailsforce;


/*
 * 
 * https://leetcode.com/problems/validate-binary-search-tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * */
public class binarySearchTre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(TreeNode root, Integer low ,Integer high){
	    if(root==null)return true;
	       if(low!=null&&root.val<=low){
	          return false;
	       }
	       if(high!=null&&root.val>=high){
	          return false;
	       }
	       if(root.left==null&&root.right==null)return true;
	       return isValid(root.left,low,root.val)&&isValid(root.right,root.val,high);
	    }
	    public boolean isValidBST(TreeNode root) {
	        if(root==null)return true;
	        return isValid(root,null,null);
	    }

}
