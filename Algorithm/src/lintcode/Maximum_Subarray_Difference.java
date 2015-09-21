package lintcode;

import java.util.ArrayList;

public class Maximum_Subarray_Difference {
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		int[] left_min = new int[nums.size()];
		int[] left_max = new int[nums.size()];
		int local_min = 0, local_max = 0;
		for (int i = 0; i < nums.size(); i++) {
			local_max = Math.max(nums.get(i), local_max + nums.get(i));
			local_min = Math.min(nums.get(i), local_min + nums.get(i));

			if (i == 0) {
				left_min[i] = local_min;
				left_max[i] = local_max;
			} else {
				left_min[i] = Math.min(local_min, left_min[i - 1]);
				left_max[i] = Math.max(local_max, left_max[i - 1]);
			}
		}

		local_min = 0;
		local_max = 0;
		int right_max = 0, right_min = 0;
		int max = Integer.MIN_VALUE;
		for (int i = nums.size() - 1; i > 0; i--) {
			local_max = Math.max(nums.get(i), local_max + nums.get(i));
			local_min = Math.min(nums.get(i), local_min + nums.get(i));

			if (i == nums.size() - 1) {
				right_max = local_max;
				right_min = local_min;
			} else {
				right_min = Math.min(local_min, right_min);
				right_max = Math.max(local_max, right_max);
			}
			max = Math.max(
					max,
					Math.max(Math.abs(right_max - left_min[i - 1]),
							Math.abs(left_max[i - 1] - right_min)));
		}
		return max;
	}
}
