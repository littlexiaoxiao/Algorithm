package MyStack;

import java.util.Arrays;

public class MyArrayStack<E> implements MyStackInterface<E>{
	private int size = 0;
	private final static int capacity = 10;
	private Object elements[];
	
	public MyArrayStack() {
		elements = new Object[capacity];
	}
	@Override
	public void push(E element) {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, size* 2);
		}
		elements[size] = element;
		size++;
	}

	@Override
	public E poll() {
		E temp = (E) elements[size-1];
		elements[size-1] = null;
		size--;
		return temp;
	}

	@Override
	public E peek() {
		return (E) elements[size-1];
	}

	@Override
	public void display() {
		System.out.println("my array stack display: ");
		for(int i = 0; i < size; i++) {
			if(i == size - 1) {
				System.out.print(elements[i]+ ".");
				System.out.println();
				return;
			}
			System.out.print(elements[i] + ", ");
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
