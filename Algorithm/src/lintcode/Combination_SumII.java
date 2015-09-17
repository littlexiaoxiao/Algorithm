package lintcode;

import java.util.*;

public class Combination_SumII {
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, nums, target, 0);
        return res;
    }

	private static void helper(List<List<Integer>> res, List<Integer> item,
			int[] nums, int target, int index) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i-1] == nums[i]) {
				continue;
			}
			item.add(nums[i]);
			helper(res, item, nums, target - nums[i], i + 1);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {3,1,3,5,1,1 };
		List<List<Integer>> res = combinationSum2(nums, 8);
		for (List<Integer> item : res) {
			System.out.println(item.toString());
		}
	}
}
