package InterviewFaang.tree;

//https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
/*Maximum Path Sum in a Binary Tree
Difficulty Level : Hard
 Last Updated : 15 Feb, 2019
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example.
1+2+3
 * */

public class max_path_sum {
	int res=Integer.MIN_VALUE; 
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
	public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }  
        int l = helper(root.left);
        int r = helper(root.right);
        int m1 = Math.max(Math.max(l,r)+root.val,root.val);
        int m2 = Math.max(m1,l+r+root.val);
        res = Math.max(res,m2);
        return m1;
    }

}
