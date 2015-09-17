package lintcode;

public class Find_LCA_BT {

	public static void main(String[] args) {
	}
	
	public TreeNodeBT findLCA_BT(TreeNodeBT root, TreeNodeBT a, TreeNodeBT b) {
		if(root == null) return null;
		
		if(root == a || root == b) return root;
		
		TreeNodeBT left = findLCA_BT(root.left, a, b);
		TreeNodeBT right = findLCA_BT(root.right, a, b);
		if(left != null && right != null) 
			return root;
		if(left != null) 
			return left;
		if(right != null)
			return right;
		
		return null;
	}

}

class TreeNodeBT {
	int val;
	TreeNodeBT right, left;
	public TreeNodeBT(int val) {
		this.val = val;
		this.right = this.left = null;
	}
}