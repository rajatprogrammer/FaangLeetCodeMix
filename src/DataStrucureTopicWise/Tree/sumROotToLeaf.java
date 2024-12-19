package DataStrucureTopicWise.Tree;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
public class sumROotToLeaf {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			val=data;
			left=right=null;
		}

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int  total(TreeNode root,int currentSum){
	        if(root==null){
	            return 0;
	        }
	        int data = currentSum*10+root.val;
	        int left=total(root.left,data);
	        int right=total(root.right,data);
	        if(right==0 && left==0){
	            return right + left +data;
	        }
	        return right + left;
	    }
	}
}
