package lintcode;

import java.util.*;

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0)
			return res;

		Collections.sort(nums);
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(res, item, nums, 0);
		return res;
	}

	private void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> item, ArrayList<Integer> nums, int start) {
		if (start > nums.size())
			return;

		res.add(new ArrayList<Integer>(item));

		for (int i = start; i < nums.size(); i++) {
			if (i > start && nums.get(i) == nums.get(i - 1)) {
				continue;
			}
			item.add(nums.get(i));
			helper(res, item, nums, i + 1);
			item.remove(item.size() - 1);
		}
	}
}
