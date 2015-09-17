package lintcode;

public class Rehashing {
	 public ListNode[] rehashing(ListNode[] hashTable) {
		 if(hashTable == null || hashTable.length ==0) {
			 return hashTable;
		 }
		 
		 int len = hashTable.length * 2;
		 ListNode[] newHashTable = new ListNode[len];
		 for(int i = 0; i < hashTable.length; i++) {
			 ListNode node = hashTable[i];
			 while(node != null) {
				 int index = 0;
				 if(node.val >= 0) {
					 index = node.val % len;
				 } else {
					 index = (node.val % len + len) % len;
				 }
				 
				 if(newHashTable[index] == null) {
					 newHashTable[index] = new ListNode(node.val);
				 } else {
					 ListNode temp = newHashTable[index];
					 while(temp.next != null) {
						 temp = temp.next;
					 }
					 temp.next = new ListNode(node.val);
				 }
				 node = node.next;
			 }
		 }
		 return newHashTable;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
