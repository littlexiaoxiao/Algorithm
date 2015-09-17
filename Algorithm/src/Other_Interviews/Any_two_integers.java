package Other_Interviews;

import java.util.HashSet;

public class Any_two_integers {
	public static boolean any_two_integers(int[] array, int target) {
		HashSet<Double> set = new HashSet<Double>();
		for(int i = 0; i < array.length; i++) {
			if(set.contains((double)array[i])){
				return true;
			} else {
				if(array[i] == 0) {
					set.add((double)0);
					continue;
				}
				double temp = target / (100 * array[i]);
				set.add(temp);
				System.out.println("set add = " + (double)array[i]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] array = {0,111,0,3,4,6,7,8,9};
		System.out.println(any_two_integers(array, 1000));

	}

}
