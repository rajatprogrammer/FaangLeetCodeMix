package InterviewFaang.tree;
//https://leetcode.com/problems/unique-binary-search-trees-ii/
//https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
import java.util.ArrayList;
import java.util.List;
public class unique_tree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<TreeNode> generateTrees(int n) {
	        if(n == 0){
	            return new ArrayList<TreeNode>();
	        }
	        return dfs(1, n);
	    }
	    
	    public List<TreeNode> dfs(int l, int r){
	        List<TreeNode> res = new ArrayList<>();
	        if(l > r){
	            res.add(null);
	            return res;
	        }
	        if(l == r){
	            res.add(new TreeNode(l));
	            return res;
	        }
	        for(int i = l; i <= r; i++){
	            List<TreeNode> left = dfs(l, i-1);
	            List<TreeNode> right = dfs(i+1, r);
	            for(TreeNode t : left){
	                for(TreeNode p : right){
	                    res.add(new TreeNode(i, t, p));
	                }
	            }
	        }
	        return res;
	    }

}
