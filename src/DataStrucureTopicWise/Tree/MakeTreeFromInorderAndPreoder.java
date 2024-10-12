package DataStrucureTopicWise.Tree;

import java.util.HashMap;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class MakeTreeFromInorderAndPreoder {

	    int preorderIndex=0;
	    static class TreeNode{
			int val;
			TreeNode left;
			TreeNode right;
			public TreeNode(int data) {
				val=data;
				left=right=null;
			}
		}
	    HashMap<Integer,Integer> hs = new HashMap<>();
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        for(int i=0;i<inorder.length;i++){
	            hs.put(inorder[i],i);
	        }
	        return build(preorder,0,preorder.length-1);
	    }
	    public TreeNode build(int preorder[],int left,int right){
	        if(left > right){
	            return null;
	        }
	        TreeNode root = new TreeNode(preorder[preorderIndex++]);
	        root.left =  build(preorder,left,hs.get(root.val)-1);
	        root.right = build(preorder,hs.get(root.val)+1,right);
	        return root;
	    }
	
}
