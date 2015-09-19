package lintcode;

import java.util.ArrayList;

public class Maximum_SubarrayII {
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		int[] left = new int[nums.size()];
		int[] right = new int[nums.size()];
		int local = 0;
		int global = Integer.MIN_VALUE;

		for (int i = 0; i < nums.size(); i++) {
			local = Math.max(nums.get(i), nums.get(i) + local);
			global = Math.max(local, global);
			left[i] = global;
		}

		local = 0;
		global = Integer.MIN_VALUE;
		for (int i = nums.size() - 1; i >= 0; i--) {
			local = Math.max(nums.get(i), nums.get(i) + local);
			global = Math.max(local, global);
			right[i] = global;
		}

		global = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size() - 1; i++) {
			global = Math.max(global, left[i] + right[i + 1]);
		}
		return global;
	}
}
