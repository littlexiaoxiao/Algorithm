package lintcode;

import java.util.*;

public class BinaryTreeSerialization {
	/**
	 * This method will be invoked first, you should design your own algorithm
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		res.append(root.val);
		int size = 0;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp.left == null) {
					res.append(",#");
				} else if (temp.left != null) {
					res.append("," + temp.left.val);
					queue.offer(temp.left);
				}

				if (temp.right == null) {
					res.append(",#");
				} else if (temp.right != null) {
					res.append("," + temp.right.val);
					queue.offer(temp.right);
				}
			}
		}
		return res.toString();
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;

		String[] strs = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		for (int i = 1; i < strs.length; i++) {
			TreeNode left = null, right = null;
			TreeNode parent = queue.poll();
			if (!strs[i].equals("#")) {
				left = new TreeNode(Integer.parseInt(strs[i]));
			}

			if (i + 1 < strs.length && !strs[i + 1].equals("#")) {
				right = new TreeNode(Integer.parseInt(strs[i + 1]));
			}
			parent.left = left;
			parent.right = right;
			if (left != null) {
				queue.offer(left);
			}
			if (right != null) {
				queue.offer(right);
			}
			i = i + 1;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
