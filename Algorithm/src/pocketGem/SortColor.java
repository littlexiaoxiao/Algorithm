package pocketGem;

import java.util.*;

public class SortColor {	
	public enum Color {		
		RED(0),
		WHITE(1),
		BLUE(2);
		private int value;
		Color(int x) {
			value = x;
		}
	}
	
	public static void swap(Color[] array, int i, int j) {
		Color temp = array[i];
		array[i] = array[j];
		array[j] = temp;		
	}
	//o(n)
	public static void sort(Color[] array) {
		if(array == null || array.length == 0)
			return;
	
		int left = 0;
		int right = array.length -1;
		int pointer = 0;
		while(pointer <= right) {
			if(array[pointer].value == 0) {
				swap(array, left, pointer);
				left ++;
				pointer ++;
			} else if (array[pointer].value == 1) {
				pointer ++;
			} else if (array[pointer].value == 2) {
				swap(array, right, pointer);
				right --;
			}
		}
	}
	//o(nlogn)
	public static class myComparator implements Comparator<Color> {
		public int compare(Color o1, Color o2) {
			return o1.value - o2.value;
		}
	}
	
	public static void sort2 (Color[] array) {
		if(array == null || array.length == 0)
			return;
		
		Arrays.sort(array, new myComparator());
	}
	
	public static void main(String[] args) {
		Color[] t = {Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE};
		sort(t);
		for(Color c : t)
			System.out.print(c + ", ");
		
		System.out.println();
		//Color[] t2 = {Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE, Color.BLUE, Color.RED, Color.WHITE};
	    sort2(t);
	      for(Color c : t)
	    	  System.out.print(c + ", ");
	}

}
