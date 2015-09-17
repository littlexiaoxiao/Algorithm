package MyQueue;

public class MyLinkedListQueue<E> implements MyQueueInterface<E> {
	private int size = 0;
	//private final static int capacity = 10;
	private Node<E> head;
	private Node<E> tail;
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E element){
			this.element = element;
			this.next = null;
		}
	}

	public MyLinkedListQueue(){
		head = null;
		tail = null;
	}

	@Override
	public void offer(E element) {
		Node<E> oldTail = tail;
		tail = new Node<E>(element);
		if(isEmpty()) {
			head = tail;
		} else {
			oldTail.next = tail;
		}
		size ++;
	}

	@Override
	public E peek() {
		return (E) head.element;
	}

	@Override
	public E poll() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("The queue is empty.");
		}		
		Node<E> temp = head;
		head = head.next;
		size--;
		if(isEmpty()) {
			tail = null;
		}
		return temp.element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void display() {
		Node<E> cur = head;
		System.out.println("linkedlist queue display: ");
		while(cur != null) {
			if(cur.next == null) {
				System.out.print(cur.element.toString() + ".");
				System.out.println();
				return;
			}
			System.out.print(cur.element.toString() + ", ");
			cur = cur.next;
		}
	}

}
