package booking;

import java.util.*;

public class Q1 {
	public static void main(String[] args){
		int[] array = { 3,6,61,6,7,9,1,7,7,2,7,7,2,388,3,72,7};
		// output [ [3,6,61],[6,7,9],[1,7,7],[2,7,7],[2,388],[3,72],[7] ]
		nondecreasing_subsequences(array);		
		int[] res = solution(array, 8);
		System.out.println(res[0]);
	}
	
	public static List<List<Integer>> nondecreasing_subsequences(int[] array) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (array == null || array.length == 0)
			return res;

		List<Integer> item = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			item.add(array[i]);
			if (i == array.length - 1) {
				res.add(new ArrayList<Integer>(item));
			} else if (i > 0 && array[i] > array[i + 1]) {
				res.add(new ArrayList<Integer>(item));
				item = new ArrayList<Integer>();
			}
		}
		return res;
	}
	
	public static int[] solution(int[] nums, int target) {
	    int[] res = new int[2];
	    if(nums == null || nums.length < 2) 
	        return null;
	    
	    int temp = target;
	    res[0] = nums[0];
	    for(int i = 1; i < nums.length; i++) {
	        
	        if( temp - res[0] ==  nums[i]) {
	            res[1] = nums[i];
	            break;
	        }
	        
	        res[0] = nums[i];
	    }
	    return res;
	}

}
