package DataStrucureTopicWise.Tree;

/*
 * https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=company&envId=oracle&favoriteSlug=oracle-six-months
 * */
public class DeleteBstNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public TreeNode deleteNode(TreeNode root, int key) {
	        //search
	        if(root == null ) {
	            return null;
	        }
	        if(root.val<key){
	            root.right = deleteNode(root.right,key);
	        }
	        else if(root.val>key) {
	            root.left = deleteNode(root.left,key);
	        }
	        else{
	            //case 1: leaf node
	            if(root.left == null && root.right == null ) {
	                return null;
	            }
	            //case 2 : one child
	            if(root.left ==  null){
	                return root.right;
	            }
	            else if(root.right ==  null ) {
	                return root.left;
	            }
	            //case 3 : two children
	            TreeNode IS = findInOrderSuccessor(root.right);
	            root.val = IS.val;

	            
	            root.right = deleteNode(root.right,IS.val);
	        }
	        return root;

	    }
	    private TreeNode findInOrderSuccessor(TreeNode root){
	        while(root.left != null){
	            root = root.left;
	        }
	        return root;
	    }

}
