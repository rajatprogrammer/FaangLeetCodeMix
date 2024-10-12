package DataStrucureTopicWise.Tree;

import java.util.ArrayList;
import java.util.List;

import DataStrucureTopicWise.Tree.closest_leaf.Node;

//
public class BalancedTree {
	static class TreeNode  
	{ 
	    int val; 
	    TreeNode left;
	    TreeNode right; 
	   
	    public TreeNode(int key,TreeNode left,TreeNode right)  
	    { 
	    	TreeNode root= new TreeNode(key, left, right);
	    	root.val = key;
	    	root.left = left;
	    	root.right = right;
	    } 
	}
	List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private void dfs(TreeNode node) {
		    if (node == null) return;

		    dfs(node.left);
		    list.add(node.val);
		    dfs(node.right);
}

		  private TreeNode constructTree(int l, int r) {
		    if (l > r) return null;

		    int m = l + (r - l) / 2;

		    return new TreeNode(list.get(m), constructTree(l, m-1), constructTree(m+1, r));
		  }

		  public TreeNode balanceBST(TreeNode root) {
		    dfs(root);
		    return constructTree(0, list.size() - 1);
		  }
		}

}
