package lintcode;

public class Nth_to_Last_Node_in_List {
	   ListNode nthToLast(ListNode head, int n) {
	        if(n <= 0|| head == null ) return null;
	        
	        int len = 0;
	        ListNode cur = head;
	        while(cur != null) {
	            cur = cur.next;
	            len++;
	        }
	        
	        cur = head;
	        for(int i = 0; i < len - n ; i ++) {
	            cur = cur.next;
	        }
	        return cur;
	    }
	public static void main(String[] args) {
	}

}
