package lintcode;

public class Segment_Tree_QueryII {
	 public int query(SegmentTreeNode root, int start, int end) {
         if(root == null || root.start > end  || root.end < start) {
             return 0;
         }
         
         if(root.start == root.end) {
             return root.count_max;
         }
         
         return query(root.left, start, end) + query(root.right, start, end);
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
