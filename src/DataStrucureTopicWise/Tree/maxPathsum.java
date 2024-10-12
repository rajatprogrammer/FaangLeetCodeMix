package DataStrucureTopicWise.Tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class maxPathsum {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			val=data;
			left=right=null;
		}
	}
	int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    public int maxPathSum(TreeNode root) {
	           maxSum(root);  
	           return max;
	    }
	    public int maxSum(TreeNode root){
	        if(root==null){
	            return 0;
	        }else{
	            int leftVal = maxSum(root.left);
	            int rightval = maxSum(root.right);
	            int total = root.val + leftVal + rightval;
	            int lf = root.val  + leftVal ;
	            int rf =  root.val + rightval;
	            int cur_max = Math.max(total,lf);
	            cur_max = Math.max(cur_max,rf);
	            max = Math.max(max,cur_max);
	            return cur_max;
	        }
	    }

}
