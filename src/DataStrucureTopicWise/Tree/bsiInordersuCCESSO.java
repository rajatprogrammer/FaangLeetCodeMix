package DataStrucureTopicWise.Tree;
//https://leetcode.com/problems/inorder-successor-in-bst/
public class bsiInordersuCCESSO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        
	        TreeNode successor = null;
	        
	        while (root != null) {
	            
	            if (p.val >= root.val) {
	                root = root.right;
	            } else {
	                successor = root;
	                root = root.left;
	            }
	        }
	        
	        return successor;
	    }

}
