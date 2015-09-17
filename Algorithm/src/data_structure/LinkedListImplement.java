package data_structure;


public class LinkedListImplement<Object> {
	private int count = 0;
	private Node<Object> head = null;
	
	public void addFirst(Object data) {
		head = new Node<Object>(data, head);
		count ++;
	}
	
	public void addLast(Object  data) {
		count ++;
		if(head == null) {
			addFirst(data);
		} else {
			Node<Object> temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<Object>(data, null);
		}
	}
	
	public void delete(Object key) {
		if(head == null) {
			throw new RuntimeException("cannot delete");
		}
		
		Node<Object> pre = null;
		Node<Object> cur = head;
		while(cur != null && !cur.data.equals(key)) {
			pre = cur;
			cur = cur.next;
		}
		
		if(cur == null) {
			//throw new RuntimeException("cannot delete");
			System.out.println("cannot find this node");
			return;
		}
		pre.next = cur.next;
		count --;
	}
	
	public boolean isEmpty() {
		return count == 0 ;
	}
	
	public int size() {
		return count;
	}
	
	public String toString() {
		String res = "[";
		Node<Object> node = head;
		while(node != null) {
			if(node.next == null) {
				res += node.data + "]";
				break;
			}
			res += node.data + ", ";
			node = node.next;
		}
		return res;
	}
	
	private class Node<Object> {
		Node<Object> next;
		Object data;
		
		public Node (Object dataValue, Node<Object> nextNode) {
			this.data = dataValue;
			this.next = nextNode;
		}
	}
	
	public static void main(String[] args) {
		LinkedListImplement<Integer> list = new LinkedListImplement<Integer>();
		list.addFirst(1);
		System.out.print("1--------");
		list.addFirst(2);
		System.out.print("2--------");
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		System.out.println(list.isEmpty());
		System.out.println("size = " + list.size());
		System.out.println(list.toString());
		list.delete(3);
		list.delete(10);
		System.out.print("3--------");
	}
}

