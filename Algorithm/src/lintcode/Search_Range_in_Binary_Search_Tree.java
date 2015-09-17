package lintcode;

import java.util.*;

public class Search_Range_in_Binary_Search_Tree {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null)  return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>(); // only store left child;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(cur.val >= k1 && cur.val <= k2) {
                    res.add(cur.val);
                }
                cur = cur.right;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
