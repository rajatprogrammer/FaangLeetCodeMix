package DataStrucureTopicWise.Tree;

import java.util.HashSet;
import java.util.Set;

import DataStrucureTopicWise.Tree.closest_leaf.Node;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days
 * */
public class LCSII {
	
	static class Node  
	{ 
	    int val; 
	    Node left, right; 
	    Node parent;
	   
	    public Node(int key)  
	    { 
	        this.val = key; 
	        left = right = null; 
	    } 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> nodes = new HashSet<>();
        while (p != null) {
            nodes.add(p.val);
            p = p.parent;
        }
        while (q != null) {
            if (nodes.contains(q.val)) return q;
            q = q.parent;
        }
        return q;
    }
	
	//space optimzized solution
	public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p;
        Node p2 = q;
        while (p1 != p2) {
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;
        }
        return p1;
    }

}
