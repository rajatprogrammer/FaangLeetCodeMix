package CompanyWiseLeetcode.sailsforce;

import java.util.List;

/*
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 

Example 1:


Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:

Input: root = [1]
Output: [[1]]
 
 * 
 * */
public class findTheLeafOfbinaryTree {

	 private List<List<Integer>> solution;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    
	    private int getHeight(TreeNode root) {
	        
	        // return -1 for null nodes
	        if (root == null) {
	            return -1;
	        }
	        
	        // first calculate the height of the left and right children
	        int leftHeight = getHeight(root.left);
	        int rightHeight = getHeight(root.right);
	        
	        int currHeight = Math.max(leftHeight, rightHeight) + 1;
	        
	        if (this.solution.size() == currHeight) {
	            this.solution.add(new ArrayList<>());
	        }
	        
	        this.solution.get(currHeight).add(root.val);
	        
	        return currHeight;
	    }
	    
	    public List<List<Integer>> findLeaves(TreeNode root) {
	        this.solution = new ArrayList<>();
	        
	        getHeight(root);
	        
	        return this.solution;
	    }

}
