package DataStrucureTopicWise.Tree;
//https://leetcode.com/problems/recover-binary-search-tree/description/
public class Recover_bianry_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode first = null,second = null,previous = null;
    public void helper(TreeNode root)
    {
        if(root== null)return;
        helper(root.left);
        if(previous!=null && previous.val>=root.val)
        {
            // set the value of first only when second is null
            if(second == null)first = previous;
            second = root;
        }
        previous = root;
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        helper(root);
        // System.out.print("first"+ first.val+" second"+second.val);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
