package DataStrucureTopicWise.Tree;

import DataStrucureTopicWise.Tree.sumROotToLeaf.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class LCA_ancestor {
	
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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode lf = lowestCommonAncestor(root.left,p,q);
        TreeNode rf = lowestCommonAncestor(root.right,p,q);
        if(lf!=null && rf!=null){
            return root;
        }
        return lf!=null?lf:rf;
    }

}
