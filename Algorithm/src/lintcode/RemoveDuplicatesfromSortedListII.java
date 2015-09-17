package lintcode;

public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
	    dummy.next = head;
		ListNode cur = dummy;
		while(cur.next != null && cur.next.next != null) {
		    if(cur.next.val == cur.next.next.val) {
		        int val = cur.next.val;
		        while(cur.next != null && cur.next.val == val) {
		            cur.next = cur.next.next;
		        }
		    } else {
		        cur = cur.next;
		    }
		}
        return dummy.next;
	}

	public static void main(String[] args) {
		// 0->1->1->2->3->null
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}
