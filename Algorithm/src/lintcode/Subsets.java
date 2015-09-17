package lintcode;

import java.util.*;

public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0)
			return res;

		Collections.sort(nums);
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(res, item, nums, 0);
		return res;
	}

	private static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> item, ArrayList<Integer> nums, int start) {
		if (start > nums.size())
			return;

		System.out.println(item.toString());
		res.add(new ArrayList<Integer>(item));
		for (int i = start; i < nums.size(); i++) {
			item.add(nums.get(i));
			helper(res, item, nums, i + 1);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		subsets(nums);
	}

}
