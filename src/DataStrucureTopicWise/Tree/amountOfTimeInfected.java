package DataStrucureTopicWise.Tree;
/*
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 * */
public class amountOfTimeInfected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 private int maxDistance = 0;

	    public int amountOfTime(TreeNode root, int start) {
	        traverse(root, start);
	        return maxDistance;
	    }

	    public int traverse(TreeNode root, int start) {
	        int depth = 0;
	        if (root == null) {
	            return depth;
	        }

	        int leftDepth = traverse(root.left, start);
	        int rightDepth = traverse(root.right, start);

	        if (root.val == start) {
	            maxDistance = Math.max(leftDepth, rightDepth);
	            depth = -1;
	        } else if (leftDepth >= 0 && rightDepth >= 0) {
	            depth = Math.max(leftDepth, rightDepth) + 1;
	        } else {
	            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
	            maxDistance = Math.max(maxDistance, distance);
	            depth = Math.min(leftDepth, rightDepth) - 1;
	        }

	        return depth;
	    }

}
