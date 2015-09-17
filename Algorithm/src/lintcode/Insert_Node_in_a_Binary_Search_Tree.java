package lintcode;

public class Insert_Node_in_a_Binary_Search_Tree {
	public static TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		if (node == null) {
			return root;
		}

		TreeNode cur = root;
		while (cur != null) {
			if (node.val > cur.val) {
				if (cur.right == null) {
					cur.right = node;
					break;
				}
				cur = cur.right;
			} else {
				if (cur.left == null) {
					cur.left = node;
					break;
				}
				cur = cur.left;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		TreeNode node = new TreeNode(3);
		TreeNode res = insertNode(root, node);
		System.out.println();
		System.out.print(res.val + ", ");
		System.out.print(res.left.val + ", ");
		System.out.print(res.right);
	}
}
