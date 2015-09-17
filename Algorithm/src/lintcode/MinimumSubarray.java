package lintcode;

import java.util.ArrayList;

public class MinimumSubarray {
	public int minSubArray(ArrayList<Integer> nums) {
		int local_max = 0;
		int global_max = Integer.MAX_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			local_max = Math.min(local_max + nums.get(i), nums.get(i));
			global_max = Math.min(global_max, local_max);
		}
		return global_max;
	}
}
