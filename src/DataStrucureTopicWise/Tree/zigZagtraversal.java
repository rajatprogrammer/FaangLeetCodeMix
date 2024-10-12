package DataStrucureTopicWise.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigZagtraversal {
	
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
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	       List<List<Integer>> res=new ArrayList<>();
	        if(root==null)
	            return res;
	        Queue<TreeNode> q=new LinkedList<>();
	        q.offer(root);
	        boolean left=true;
	        while(!q.isEmpty()){
	            List<Integer> level=new ArrayList<>();
	            int s=q.size();
	            for(int i=0 ; i<s ; ++i){
	                TreeNode temp=q.poll();
	                
	                if(left==true)
	                    level.add(temp.val);       //FIFO normal order
	                else
	                    level.add(0, temp.val);    //Reverse order by adding element to front of list.
	                
	                if(temp.left!=null)
	                    q.offer(temp.left);
	                if(temp.right!=null)
	                    q.offer(temp.right);
	            }
	            left=!left;               //toggle this value for every iteration
	            res.add(level);        //level added to result
	        }
	        return res;
	    }

}
