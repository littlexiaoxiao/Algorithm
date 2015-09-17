package lintcode;

public class Segment_Tree_Build {
    public SegmentTreeNode build(int start, int end) {
        if(start > end) return null;

        if(start == end) {
            return new SegmentTreeNode(start, end);
        }        
        
        SegmentTreeNode node = new SegmentTreeNode(start, end);

        node.left = build(start, (start + end)/2);
        node.right = build((start+end)/2+1, end);        
        return node;
    }
}
