package lintcode;

import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return res;
		}

		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(res, item, nums);
		return res;
	}

	private void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> item, ArrayList<Integer> nums) {
		if (item.size() == nums.size()) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (item.contains(nums.get(i))) {
				continue;
			}
			item.add(nums.get(i));
			helper(res, item, nums);
			item.remove(item.size() - 1);
		}
	}
}
