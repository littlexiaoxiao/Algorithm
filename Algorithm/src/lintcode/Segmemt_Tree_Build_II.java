package lintcode;

public class Segmemt_Tree_Build_II {
    public SegmentTreeNode build(int[] nums) {
        if(nums == null || nums.length == 0) 
            return null;
        
        return helper(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start != end) {
            node.left = helper(nums, start, (start + end)/2);
            node.right = helper(nums, (start+end)/2+1, end);
            node.count_max = Math.max(node.left.count_max, node.right.count_max);
        } else {
            node.count_max = nums[start];
        }
        
        return node;
    }
}
