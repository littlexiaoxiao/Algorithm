package lintcode;

public class Trapping_Rain_Water {
	public int trapRainWater(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int res = 0;

		left[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			left[i] = Math.max(left[i - 1], nums[i]);
		}

		right[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			left[i] = Math.min(left[i], right[i]);
			res += left[i] - nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
