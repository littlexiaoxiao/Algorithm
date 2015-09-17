package pocketGem;

import java.util.*;

public class Find_Next_Bigger_Node_in_BST {
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int v) {
			value = v;
			left = null;
			right = null;
			parent = null;
		}
	}
	// 二叉树： sub-left tree and sub-right tree; 左孩子小于根节点，右孩子大于根节点。no duplicate nodes
	// 平衡二叉树： 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
	public static TreeNode smallestNode (TreeNode root) {
		if(root == null)
			return root;
		
		TreeNode cur = root;
		while(cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
	
	//has parent pointer
	//平衡的 就 O(log n), 不平衡就是 n
	public static TreeNode nextNode (TreeNode node) {
		if(node.right != null) {
			TreeNode cur = node.right;
			while(cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			//it's a right node ,need to find the first left-node and return this node's parent node
			TreeNode cur = node;
			while(node.parent != null && cur.parent.right == cur){
				cur = cur.parent;
			}
			return cur.parent;
		}
	}
	
	// no parent pointer 
	public static TreeNode nextNode (TreeNode root, TreeNode node) {
		if(node.right != null) {
			TreeNode cur = node.right;
			while(cur.left != null)
				cur = cur.left;
			return cur;
		} else {
			TreeNode cur = root;
			TreeNode parent = null;
			while(cur.value != node.value) {
				if(cur.value > node.value) {
					parent = cur;
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}
			return parent;
		}
	}
	
	// cannot use value
	public static TreeNode nextNode2(TreeNode root, TreeNode node) {
		List<TreeNode> inorder = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			return null;
		
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				inorder.add(cur);
				cur = cur.right;
			}
		}
		// == 比较的是address
		for(int i = 0; i < inorder.size(); i++) {
		if(i != inorder.size()-1 && inorder.get(i) == node)
			return inorder.get(i+1);
		}
		return null;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
