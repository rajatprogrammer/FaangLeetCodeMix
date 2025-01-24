package CompanyWiseLeetcode.sailsforce;

/*
 * https://leetcode.com/problems/path-sum-iii
 * 
 * */
public class Path_sum {
	
	int paths = 0;
	
	private void helper (TreeNode root, int sum) {
		
		if (root != null && root.val == sum) {
			++paths;
		}
		if (root != null) {
			sum -= root.val;
			helper (root.left, sum);
			helper (root.right, sum);
		}
	}
	
	public int pathSum (TreeNode root, int sum) {
		
		if (root == null) {
			return 0;
		}
		helper (root, sum);
		pathSum (root.left, sum);
		pathSum (root.right, sum);
		return paths;
	}
}
