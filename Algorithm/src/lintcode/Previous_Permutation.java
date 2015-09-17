package lintcode;

import java.util.ArrayList;

public class Previous_Permutation {
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return nums;
		}

		int small = 0;
		int big = 0;
		for (int i = nums.size() - 1; i > 0; i--) {
			if (nums.get(i) < nums.get(i - 1)) {
				big = i - 1;
				break;
			}
		}

		if (big == 0 && nums.get(big) < nums.get(big + 1)) {
			reverse(nums, big, nums.size() - 1);
			return nums;
		}

		for (int i = nums.size() - 1; i >= 0; i--) {
			if (nums.get(i) < nums.get(big)) {
				small = i;
				break;
			}
		}
		swap(nums, big, small);
		reverse(nums, big + 1, nums.size() - 1);
		return nums;
	}

	private void swap(ArrayList<Integer> nums, int index1, int index2) {
		int temp = nums.get(index1);
		nums.set(index1, nums.get(index2));
		nums.set(index2, temp);
	}

	private void reverse(ArrayList<Integer> nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
