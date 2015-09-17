package lintcode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode newstart = dummy1;
		ListNode connect = dummy2;
		while (head != null) {
			if (head.val < x) {
				dummy1.next = head;
				dummy1 = dummy1.next;
			} else {
				dummy2.next = head;
				dummy2 = dummy2.next;
			}
			head = head.next;
		}
		dummy1.next = connect.next;
		dummy2.next = null;
		return newstart.next;
	}
}
