package LeetCode;
import java.util.*;

public class Q191_number_of_1bit {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		ListNode cur = head;
		while (cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println("above");
		reverseBetween(head,1,2);
	}
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        if(m == n)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newhead = dummy;
        ListNode start = null;
        ListNode end = null;
        ListNode realStart = null;
        ListNode realEnd = null;
        ListNode temp = null;
        for(int i = 0; i< n; i++) {
            if(i < m) {
                temp = newhead;
            } else if (i == m) {
                realStart = temp;
                start = newhead;
            } else {
                end = newhead;
                System.out.println("end value  " + end.val);
                realEnd = end.next;
            }
            newhead = newhead.next;
            
            ListNode test = newhead.next;            
            //test
            while(test != null) {
            	System.out.print(test.val +" ");
            	test = test.next;
            }
            System.out.println();
            //test           
        }
        
        //ListNode realEnd = end.next;
        end.next =null;
        
        realStart.next = reverse(start);
        start.next = realEnd;
        
        ListNode test2 = dummy.next;
        while(test2 != null) {
        	System.out.print(test2.val + " ");
        	test2 = test2.next;
        }
        return dummy.next;
        
    }
    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    
    public static class ListNode {
    	      int val;
    	    ListNode next;
    	     ListNode(int x) { val = x; }
    	 }
}