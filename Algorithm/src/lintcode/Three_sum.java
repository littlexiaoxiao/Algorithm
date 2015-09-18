package lintcode;

import java.util.*;

public class Three_sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		int left = 0, right = 0, sum = 0;
		ArrayList<Integer> item = new ArrayList<Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else if (sum == 0) {
					item = new ArrayList<Integer>();
					item.add(nums[i]);
					item.add(nums[left]);
					item.add(nums[right]);
					Collections.sort(item);
					if (!res.contains(item)) {
						res.add(new ArrayList<Integer>(item));
					}
					left++;
					right--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
