package MyQueue;

import java.util.Arrays;

public class MyArrayQueue<E> implements MyQueueInterface<E> {
	private int size = 0;
	private final static int capacity = 10;
	private Object elements[];
	private int head = 0;
	private int tail = 0;

	public MyArrayQueue() {
		elements = new Object[capacity];
	}

	@Override
	public void offer(E element) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, size * 2);
		}
		elements[size] = element;
		size++;
		tail++;
	}

	@Override
	public E peek() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException("It is an empty queue");
		} else {
			return (E) elements[head];
		}
	}

	@Override
	public E poll() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException("It is an empty queue");
		}
		E temp = peek();
		size--;
		for(int i = 0; i < size; i++) {
			elements[i] = elements[i+1];
		}
		return temp;
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
		System.out.println("array queue display: ");
		for (int i = head; i < tail; i++) {
			if (i == size() - 1) {
				System.out.print(elements[i] + ".");
				System.out.println();
				return;
			}
			System.out.print(elements[i] + ", ");
		}
	}
}
