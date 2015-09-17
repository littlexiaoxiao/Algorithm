public class Palindrome_Linked_List {

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondhalf = slow.next;
		secondhalf = reverse(secondhalf);
		ListNode firsthalf = head;
		while (secondhalf != null) {
			if (secondhalf.val != firsthalf.val) {
				return false;
			}
			firsthalf = firsthalf.next;
			secondhalf = secondhalf.next;
		}
		return true;
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
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}
}
