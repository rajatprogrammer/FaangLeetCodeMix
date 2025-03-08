package DataStrucureTopicWise.Tree;

/*
 * Linkdien 
* A tournament tree is a binary tree 
* where the parent is the minimum of the two children. 
* Given a tournament tree find the second minimum value in the tree. 
* A node in the tree will always have 2 or 0 children. 
* Also all leaves will have distinct and unique values. 
*         2 
*      /    \ 
*     2      3 
*    / \    /  \    
*   4   2   5   3 
* 
* In this given tree the answer is 3. 
*/




public class TournamentTree {
	
	static class Node {
		  Integer val;
		  Node left, right;
		  Node(Integer value, Node left, Node right) {
		    this.val = value;
		    this.left = left;
		    this.right = right;
		  }
		}
	
		public static Integer secondMin(Node root) {
	        if(root.left == null || root.right == null) return Integer.MAX_VALUE;
	        int min;
	        if(root.left.val == root.val) {
	            min = Math.min(root.right.val, secondMin(root.left));
	        } else {
	            min = Math.min(root.left.val, secondMin(root.right));
	        }
	        
	        return min;
	    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
