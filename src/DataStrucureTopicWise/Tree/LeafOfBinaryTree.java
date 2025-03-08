package DataStrucureTopicWise.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 * 
 * 
 * */
public class LeafOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	    public List<List<Integer>> findLeaves(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        height(root, res);
	        return res;
	    }
	    private int height(TreeNode node, List<List<Integer>> res){
	        if(null==node)  return -1;
	        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
	        if(res.size()<level+1)  res.add(new ArrayList<>());
	        res.get(level).add(node.val);
	        return level;
	    }
	}

}
