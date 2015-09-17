import java.util.*;


public class Q95_Unique_Binary_Search_Trees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftList = (ArrayList<TreeNode>) helper(start, i -1);
            ArrayList<TreeNode> rightList = (ArrayList<TreeNode>) helper(i+1, end);
            
            for(int m = 0; m< leftList.size(); m++) {
                for(int j = 0; j < rightList.size(); j++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftList.get(m);
                    node.right = rightList.get(j);
                    res.add(node);
                }
            }
        }
        return res;
    }
 }
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

