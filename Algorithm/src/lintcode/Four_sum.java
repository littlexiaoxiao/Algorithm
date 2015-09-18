package lintcode;

import java.util.*;

public class Four_sum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.length <= 3) {
			return res;
		}

		Arrays.sort(nums);
		int left = 0, right = 0, sum = 0;
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				left = j + 1;
				right = nums.length - 1;
				while (left < right) {
					if (left > j + 1 && nums[left] == nums[left - 1]) {
						left++;
						continue;
					}
					sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						item = new ArrayList<Integer>();
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[left]);
						item.add(nums[right]);
						res.add(new ArrayList<Integer>(item));
						left++;
						right--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
