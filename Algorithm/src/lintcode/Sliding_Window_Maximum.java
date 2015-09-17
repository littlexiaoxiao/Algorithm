package lintcode;

import java.util.*;

public class Sliding_Window_Maximum {
	public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || k <= 0)
			return res;

		PQsort pqs = new PQsort();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, pqs);

		for (int i = 0; i < nums.length; i++) {
			int j = i;
			while(queue.size() < k && j < nums.length) {
				queue.offer(nums[j]);
				j++;
			}	
			if(queue.size() == k) {
				res.add(queue.poll());
			}
			queue.clear();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,7,7,2 };
		ArrayList<Integer> res = maxSlidingWindow(nums, 3);
		for (Integer i : res) {
			System.out.print(i + ", ");
		}
	}
}

class PQsort implements Comparator<Integer> {
	public int compare(Integer one, Integer two) {
		return two - one;
	}
}
