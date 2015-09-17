package lintcode;

public class Minimum_Size_Subarray_Sum {
	public static int minimumSize(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		while (end < nums.length) {
			sum += nums[end];
			while (sum >= s) {
				min = Math.min(min, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2113, 1, 1 };
		System.out.println(minimumSize(nums, 12345));
	}
}
