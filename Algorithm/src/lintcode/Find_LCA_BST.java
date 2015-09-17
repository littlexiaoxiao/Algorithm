package lintcode;

public class Find_LCA_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
		if(root == null) return null;
		
		if(a.val > root.val && b.val > root.val) 
			return findLCA(root.right, a, b);
		
		else if(a.val < root.val && b.val < root.val) 
			return findLCA(root.left , a, b);
		
		else 
			return root;
	}
}

