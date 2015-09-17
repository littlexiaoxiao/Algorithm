package lintcode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode node, int[] max) {
		if (node == null)
			return 0;

		int left = helper(node.left, max);
		int right = helper(node.right, max);
		int singleroad = Math.max(node.val, Math.max(left, right) + node.val);
		max[0] = Math
				.max(Math.max(singleroad, left + right + node.val), max[0]);
		return singleroad;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
