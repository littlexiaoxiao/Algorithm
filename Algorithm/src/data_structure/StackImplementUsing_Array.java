package data_structure;

import java.util.Arrays;

public class StackImplementUsing_Array<E> {
	private int size = 0;
	private Object elements[];
	private final static int capacity = 10;
	
	public StackImplementUsing_Array(){
		elements = new Object[capacity];
	}
	public int size() {
		return size;
	}
	
	public void push(E element) {
		if(size == elements.length){
			elements = Arrays.copyOf(elements, size * 2);
		}
		elements[size] = element;
		size++;
	}
	
	public E peek() {
		if(elements.length == 0) {
			throw new IndexOutOfBoundsException("It is an empty stack.");
		}
		E temp = (E) elements[size-1];
		return temp;
	}
	
	public E pop() {
		if(elements.length == 0) {
			throw new IndexOutOfBoundsException("It is an empty stack.");
		}
		E temp = peek();
		elements[size-1] = null;
		size--;
		return temp;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		StackImplementUsing_Array<Integer> stack = new StackImplementUsing_Array<Integer>();
		System.out.println("original size is " + stack.size());
		for(int i = 1; i <= 20; i++) {
			stack.push(i);
		}
		System.out.println("current size = " + stack.size());
		System.out.println("remove one " + stack.pop());
		System.out.println("current size = " + stack.size());
		System.out.println("current stack.peek() = " + stack.peek());
		for(int i = 0; i < 5; i++) {
			System.out.println("remove" + i + " " + stack.pop());
		}
		System.out.println("current size = " + stack.size());
	}

}
