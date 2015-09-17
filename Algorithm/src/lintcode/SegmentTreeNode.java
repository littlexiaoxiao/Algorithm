package lintcode;

public class SegmentTreeNode {
	public int start, end, count_max;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}

	public SegmentTreeNode(int start, int end, int count_max) {
		this.start = start;
		this.end = end;
		this.count_max = count_max;
		this.left = this.right = null;
	}
}