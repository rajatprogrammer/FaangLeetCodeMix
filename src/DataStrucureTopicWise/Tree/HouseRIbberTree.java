package DataStrucureTopicWise.Tree;

import java.util.HashMap;

//https://leetcode.com/problems/house-robber-iii/description/
public class HouseRIbberTree {
	HashMap<TreeNode, Integer> robResult = new HashMap<>();
    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
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
	public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int leftleft=0;
            int leffright=0;
            
            int rightleft=0;
            int rightright=0;
            
            if(root.left!=null){
                leftleft=rob(root.left.left);
                leffright=rob(root.left.right);
            }
            if(root.right!=null){
                rightleft=rob(root.right.left);
                rightright=rob(root.right.right);
            }
            
            int includeRoot=root.val+leftleft+leffright+rightleft+rightright;
            
            int left=rob(root.left);
            int right=rob(root.right);
            
            int excludeRoot=left+right;
            
            return Math.max(includeRoot,excludeRoot);
        }
    }
	//optimized Rob with dp memoisation
	public int helper(TreeNode node, boolean parentRobbed) {
        if (node == null) {
            return 0;
        }
        if (parentRobbed) {
            if (robResult.containsKey(node)) {
                return robResult.get(node);
            }
            int result = helper(node.left, false) + helper(node.right, false);
            robResult.put(node, result);
            return result;
        } else {
            if (notRobResult.containsKey(node)) {
                return notRobResult.get(node);
            }
            int rob = node.val + helper(node.left, true) + helper(node.right, true);
            int notRob = helper(node.left, false) + helper(node.right, false);
            int result = Math.max(rob, notRob);
            notRobResult.put(node, result);
            return result;
        }
    }
	//optimized Rob with dp memoisation
	 public int robbery(TreeNode root) {
	        return helper(root, false);
	    }

}
