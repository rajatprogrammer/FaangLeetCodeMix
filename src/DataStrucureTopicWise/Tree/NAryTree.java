package DataStrucureTopicWise.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * A variant of finding lowest common ancestor in binary tree, which was later extended to N-ary tree.
 * 
 * */
public class NAryTree {
	
	class NaryTreeNode {
	    int val;
	    List<NaryTreeNode> children;

	    NaryTreeNode(int val) {
	        this.val = val;
	        this.children = new ArrayList<>();
	    }
	}

	    public static NaryTreeNode findLCA(NaryTreeNode root, NaryTreeNode p, NaryTreeNode q) {
	        if (root == null || root == p || root == q) return root;

	        NaryTreeNode lca = null;
	        int count = 0;

	        for (NaryTreeNode child : root.children) {
	            NaryTreeNode temp = findLCA(child, p, q);
	            if (temp != null) {
	                count++;
	                lca = temp;
	            }
	            if (count > 1) return root; // More than one non-null child, root is LCA
	        }

	        return lca;
	    }

	    public static void main(String[] args) {
	        NaryTreeNode root = new  NaryTreeNode(1);
	        NaryTreeNode node2 = new NaryTreeNode(2);
	        NaryTreeNode node3 = new NaryTreeNode(3);
	        NaryTreeNode node4 = new NaryTreeNode(4);
	        NaryTreeNode node5 = new NaryTreeNode(5);
	        NaryTreeNode node6 = new NaryTreeNode(6);
	        NaryTreeNode node7 = new NaryTreeNode(7);

	        root.children.add(node2);
	        root.children.add(node3);
	        root.children.add(node4);
	        node2.children.add(node5);
	        node2.children.add(node6);
	        node3.children.add(node7);

	        NaryTreeNode p = node5;
	        NaryTreeNode q = node6;

	        NaryTreeNode lca = findLCA(root, p, q);
	        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
	    }


}
