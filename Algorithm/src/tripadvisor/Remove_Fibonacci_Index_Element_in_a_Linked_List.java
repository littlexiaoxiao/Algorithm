package tripadvisor;

import java.util.ArrayList;

public class Remove_Fibonacci_Index_Element_in_a_Linked_List {
	public static Node removeElement(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			head = null;
			return null;
		}
		int pre1  = 0;
		int pre2 = 1;
		int count = 0;
		Node cur = head;
		Node pre = new Node(-1);		
		pre.next = cur;
		Node dummy = pre;
		while(cur.next != null) {
			if(count == 0) {
				System.out.print(count + ", ");
				pre.next = cur.next;
			} else if(count == pre1 + pre2) {
				System.out.print("* "+ count + ", ");
				pre1 = pre2;
				pre2  = count;
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
			count++;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node cur = head;
		for(int i = 1; i <= 15; i++) {
			cur.next = new Node(i);
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			System.out.print(cur.val + ", ");
			cur = cur.next;
		}
		System.out.println();
		Node cur1 = removeElement(head);
		System.out.println();
		while(cur1 != null) {
			System.out.print(cur1.val + ", ");
			cur1 = cur1.next;
		}
	}
}

class Node {
	int val;
	Node next;
	Node(int x) {
		val = x;
	}
}
