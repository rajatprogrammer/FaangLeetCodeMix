package DataStrucureTopicWise.Tree;

import DataStrucureTopicWise.Tree.LongestCOnsecutive.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
 * 
 * */
public class LowestCommonAncestro {
	
	static class TreeNode  
	{ 
	    int val; 
	    TreeNode left;
	    TreeNode right; 
	   
	    public TreeNode(int key,TreeNode left,TreeNode right)  
	    { 
	    	TreeNode root= new TreeNode(key, left, right);
	    	root.val = key;
	    	root.left = left;
	    	root.right = right;
	    } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val>p.val && root.val<q.val) || (root.val>q.val && root.val<p.val))//if root.val is less than one node and greater than the other it means that the root is the lowest common ancestor
        return root;
        if(root.val>p.val && root.val>q.val)//if root.val is greater than both the nodes it means that the lowest common ancestor lies in the left subtree
        return lowestCommonAncestor(root.left,p,q);
        if((root.val<p.val && root.val<q.val) || (root.val<q.val && root.val<p.val))//if root.val is less than both the nodes it means that the lowest common ancestor lies in the right subtree
        return lowestCommonAncestor(root.right,p,q);
        return root;//dummy return statement that will never be executed since the control will never reach here(dry run recommended)(it is used for the else part as it is nessecary in leetcode)
    }


}
