package InterviewFaang.tree;
//amazon
//https://leetcode.com/problems/serialize-and-deserialize-bst/
//https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
public class serialize_bst {
	int i=0;
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
		TreeNode root = new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(7);
//		root.left.left = new TreeNode(2);
//		root.left.right=new TreeNode(4);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(10);
		serialize_bst ob1 = new serialize_bst();
		String data=ob1.serialize(root);
		System.out.print(data);
		TreeNode tempRoot = ob1.deserialize(data);
	}
	public String serialize(TreeNode root) {
        if(root == null){
            return "$";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[]dataStr = data.split(",");
        return deserialize(dataStr);
    }
    
    private TreeNode deserialize(String[]dataArr){
        if(dataArr[i].equals("$")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[i++]));
        root.left = deserialize(dataArr);
        root.right = deserialize(dataArr);
        return root;
    }

}
