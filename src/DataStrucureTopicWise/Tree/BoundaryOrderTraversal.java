package DataStrucureTopicWise.Tree;

import java.util.ArrayList;
import java.util.List;

import DataStrucureTopicWise.Tree.zigZagtraversal.TreeNode;
//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

//https://leetcode.com/problems/boundary-of-binary-tree/
//
public class BoundaryOrderTraversal {
	
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
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	    List<Integer> res = new ArrayList<Integer>();
	    if(root == null)
	        return res;
	    
	    //add root.
	    res.add(root.val);
	    
	    //add left boundary
	    formLeftBoundary(root.left, res);
	    
	    //add left leaves
	    addLeaves(root.left, res);
	    
	    //add right leaves
	    addLeaves(root.right, res);
	    
	    //add right boundary
	    formRightBoundary(root.right, res);
	    
	    return res;
	}

	private void formLeftBoundary(TreeNode root, List<Integer> res){
	    if(root == null)
	        return;
	    
	    if(root.left != null){ //only if value is not null, it should be put to the arraylist.
	        res.add(root.val);
	        formLeftBoundary(root.left, res);
	    } else if(root.right != null){
	        res.add(root.val);
	        formLeftBoundary(root.right, res);
	    }
	}

	private void formRightBoundary(TreeNode root, List<Integer> res){
	    
	    if(root == null)
	        return;
	    
	    if(root.right != null){ //only if value is not null, it should be put to the arraylist.
	        formRightBoundary(root.right, res);
	        res.add(root.val);
	    } else if(root.left != null){
	        formRightBoundary(root.left, res);
	        res.add(root.val);
	    }
	}

	private void addLeaves(TreeNode root, List<Integer> res){
	    
	    if(root == null)
	        return;
			
	    addLeaves(root.left, res);
	    
	    if(root.left == null && root.right == null)
	        res.add(root.val);
	    
	    addLeaves(root.right, res);
	}

}
