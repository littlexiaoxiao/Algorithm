package MyStack;

public interface MyStackInterface<E> {
	void push(E element);
	
	E poll();
	
	E peek();
	
	void display();
	
	int size();
	
	boolean isEmpty();
}
