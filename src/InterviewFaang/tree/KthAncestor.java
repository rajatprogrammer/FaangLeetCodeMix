package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Amazon
//https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-1-6-months-intern-on-campus/
public class KthAncestor {
	int total=0;
	  static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(1);
		KthAncestor ob1 = new KthAncestor();
		System.out.print(ob1.sum(root,2));
	}
	int sum(TreeNode root,int k) {
		HashMap<TreeNode,Integer[]> hs = new HashMap<TreeNode, Integer[]>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Integer l[] = new Integer[0];
		hs.put(root,l);
		while(!q.isEmpty()) {
			TreeNode pro = q.poll();
			if(pro.left!=null) {
				Integer[] temp = hs.get(pro);
				Integer ls[] = new Integer[temp.length+1];
				if(temp.length > 0) {
					for(int i=0;i<temp.length;i++) {
						ls[i]=temp[i];
					}
				}	
				ls[ls.length-1]=pro.val;
				hs.put(pro.left,ls);
				q.add(pro.left);	
			}
			if(pro.right!=null) {
				Integer[] temp = hs.get(pro);
				Integer ls[] = new Integer[temp.length+1];
				if(temp.length > 0) {
					for(int i=0;i<temp.length;i++) {
						ls[i]=temp[i];
					}
				}	
				ls[ls.length-1]=pro.val;
				hs.put(pro.right,ls);
				q.add(pro.right);
			}
		}
		for(Map.Entry<TreeNode, Integer[]> entry:hs.entrySet()) {
			int val = entry.getKey().val;
			Integer[] arr = entry.getValue();
			System.out.println("Key = " + entry.getKey().val + 
                    ", Value = " + Arrays.toString(entry.getValue())); 
			if(arr.length>=k) {
				if(arr[k-1]%2==0) {
					System.out.print(val);
					total=total + val;
				}
			}
		}
		return total;
	}
}
