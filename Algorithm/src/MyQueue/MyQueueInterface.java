package MyQueue;

public interface MyQueueInterface<E> {
	void offer(E element);
	
	E peek();
	
	E poll();
	
	int size();
	
	boolean isEmpty();
	
	void display();
}
