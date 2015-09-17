package MyQueue;

public class QueueTest {

	public static void main(String[] args) {
		MyArrayQueue<Integer> aqueue= new MyArrayQueue<Integer>();
		MyLinkedListQueue<Integer> lqueue = new MyLinkedListQueue<Integer>();
		System.out.println("array queue size = " +aqueue.size());
		System.out.println("linkedlist queue size = " + lqueue.size());
		
		for(int i = 1; i <= 10; i++) {
			aqueue.offer(i);
			lqueue.offer(i);
		}
		aqueue.display();		
		lqueue.display();
		System.out.println("aqueue.poll() = " +aqueue.poll());
		System.out.println("lqueue.poll() = " + lqueue.poll());
		System.out.println("array queue size = " +aqueue.size());
		System.out.println("linkedlist queue size = " + lqueue.size());
		
		aqueue.display();		
		lqueue.display();
		
		aqueue.poll();
		aqueue.poll();
		aqueue.poll();
		System.out.println("array queue size = " +aqueue.size());
		aqueue.display();
	}

}
