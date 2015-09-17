package LeetCode;
import java.util.*;


public class Q230_Kth_Smallest_Element_in_a_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int kthSmallest(TreeNode root, int k) {
        //其实相当于实现中序遍历，中序遍历是按照 sorted 的顺序
        if(root == null)
            return 0;
        
        List<Integer> inorder = new ArrayList<Integer>();
        helper(root, inorder);
        return inorder.get(k-1);
    }
    
    private static void helper(TreeNode node, List<Integer> inorder) {
        if(node == null)
            return;
        
        helper(node.left, inorder);
        inorder.add(node.val);
        helper(node.right, inorder);
    }
 }
