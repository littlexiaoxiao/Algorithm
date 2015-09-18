package lintcode;

import java.util.Arrays;

public class Three_Sum_Closest {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length <= 2)
			return 0;

		Arrays.sort(nums);
		int left = 0, right = 0, diff = 0, sum = 0, res = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				if (left > i + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				sum = nums[i] + nums[left] + nums[right];
				diff = Math.abs(sum - target);
				if (diff < min) {
					min = diff;
					res = sum;
				}

				if (sum == target) {
					return sum;
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, -1, -1, -1, 0, 1, 1, 1, 2 };
		System.out.println(threeSumClosest(nums, 7));
	}
}
