package data_structure;

import java.util.Arrays;

public class ArrayListImplement<E> {
	private Object elements[];
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayListImplement() {
		elements = new Object[DEFAULT_CAPACITY];		
	}
	
	public void add(E element){
		if(size == elements.length) {
			elements = Arrays.copyOf(elements, size * 2);
		}
		elements[size] = element;
		size ++;
	}
	
	//o(n) remove
	public E remove (int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E res = (E) elements[index];
		for(int i = index+1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		size --;
		return res;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		} else {
			return (E) elements[index];		
		}
	}
	
	public boolean search(E element) {
		for(int i = 0; i < size; i++) {
			if(elements[i].equals(element))
				return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
	  String res = "[";
	  for(int i = 0; i < size; i++) {
		  if(i == size - 1) {
			  res += elements[i] + "]";
			  break;
		  }
		  res += elements[i] + ",";
	  }
	  return res;
	}
	
	public static void main(String[] args) {
		ArrayListImplement<Integer> myArrayList = new ArrayListImplement<Integer>();
		for(int i = 0; i < 12; i ++) {
			myArrayList.add(i);
		}
		System.out.println("size of elements = " + myArrayList.size());
		System.out.println(myArrayList.toString());
		System.out.println(myArrayList.search(29));
		myArrayList.get(4);
		System.out.println("index 4 element = " + myArrayList.get(4)) ;
		myArrayList.remove(2);
		System.out.println("size of elements = " + myArrayList.size());
		System.out.println(myArrayList.toString());
	}

}
