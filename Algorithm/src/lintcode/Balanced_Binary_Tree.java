package lintcode;

public class Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return maxdepth(root) != -1;
	}

	private int maxdepth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = maxdepth(node.left);
		int right = maxdepth(node.right);
		int diff = Math.abs(right - left);
		if (diff > 1 || left == -1 || right == -1) {
			return -1;
		}
		return Math.max(right, left) + 1;
	}

	public static void main(String[] args) {

	}
}
