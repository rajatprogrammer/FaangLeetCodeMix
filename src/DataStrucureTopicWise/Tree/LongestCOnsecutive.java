package DataStrucureTopicWise.Tree;

import DataStrucureTopicWise.Tree.BalancedTree.TreeNode;

/*Given the root of a binary tree, return the length of the longest consecutive sequence path.

A consecutive sequence path is a path where the values increase by one along the path.

Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.
///https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 *
 *Input: root = [1,null,3,2,4,null,null,null,5]
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
//google walmart

 * */
public class LongestCOnsecutive {
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
	private int maxLength = 0;
	public int longestConsecutive(TreeNode root) {
	    dfs(root, null, 0);
	    return maxLength;
	}

	private void dfs(TreeNode p, TreeNode parent, int length) {
	    if (p == null) return;
	    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
	    maxLength = Math.max(maxLength, length);
	    dfs(p.left, p, length);
	    dfs(p.right, p, length);
	}

}
