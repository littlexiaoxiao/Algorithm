package lintcode;

public class ReorderList {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		ListNode sechalf = slow.next;
		slow.next = null;
		sechalf = reverse(sechalf);
		ListNode firhalf = head;
		while(sechalf != null) {
			ListNode temp1 = firhalf.next;
			ListNode temp2 = sechalf.next;
			firhalf.next = sechalf;
			sechalf.next = temp1;
			sechalf = temp2;
			firhalf = temp1;			
		}
	}

	private static ListNode reverse(ListNode node) {
		if (node == null || node.next == null)
			return node;
		ListNode pre = null;
		ListNode cur = node;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(-1);
		head.next.next = new ListNode(-2);
		reorderList(head);
		ListNode cur = head;
		while(cur != null) {
			System.out.println(cur.val + ", ");
			cur = cur.next;
		}
		System.out.println();
	}

}
