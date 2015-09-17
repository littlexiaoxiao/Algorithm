package lintcode;

public class Next_Permutation {
	public int[] nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}

		int small = 0;
		int big = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				small = i - 1;
				break;
			}
		}

		// if the array is increasing.
		if (small == 0 && nums[small] > nums[small + 1]) {
			reverse(nums, small, nums.length - 1);
			return nums;
		}

		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[small]) {
				big = i;
				break;
			}
		}
		swap(nums, small, big);
		reverse(nums, small + 1, nums.length - 1);
		return nums;
	}

	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
}
