package DataStrucureTopicWise.Tree;
import java.util.ArrayList;
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//https://www.geeksforgeeks.org/print-all-nodes-at-distance-k-from-given-node-iterative-approach/
//imp question microsoft,amazon
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		val=data;
		left=right=null;
	}
}

public class k_distance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k_distance ob1 = new k_distance();
		TreeNode root = new TreeNode(20);
		root.left =  new TreeNode(8);
		root.right =  new TreeNode(22);
		root.left.left =  new TreeNode(4);
		root.left.right =  new TreeNode(12);
		root.left.right.left =  new TreeNode(18);
		root.left.right.right =  new TreeNode(14);
		ob1.distanceK(root,root.right,1);
	}
	
	 public void addK(List<Integer> res, TreeNode root, int k) {
	        if (root == null) return;
	        if (k == 0) {
	            res.add(root.val);
	            return;
	        }
	        addK(res, root.left, k - 1);
	        addK(res, root.right, k - 1);
	    }

	    public Boolean track(ArrayList<TreeNode> list, TreeNode root, TreeNode target) {
	        if (root == null) return false;
	        if (root == target) {
	            list.add(root);
	            return true;
	        }
	        if (track(list, root.left, target)) {
	            list.add(root);
	            return true;
	        }
	        if (track(list, root.right, target)) {
	            list.add(root);
	            return true;
	        }
	        return false;
	    }

	    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
	        ArrayList<TreeNode> list = new ArrayList<>();
	        track(list, root, target);
	        List<Integer> ans = new ArrayList<>();
	        
	        for (int i = 0; i < list.size(); i++) {
	            TreeNode currNode = list.get(i);
	            if (i > 0) {
	                // this part is essential, just go wherever that hasnt been visited
	                if (currNode.left == list.get(i - 1)) currNode.left = null;
	                else currNode.right = null;
	            } 
	            if (k - i >= 0) addK(ans, list.get(i), k - i);
	        }
	        return ans;
	    }

}
