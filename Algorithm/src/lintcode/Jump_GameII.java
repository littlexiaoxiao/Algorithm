package lintcode;

public class Jump_GameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] step = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] + j >= i) {
					step[i] = step[j] + 1;
					break;
				}
			}
		}
		return step[nums.length - 1];
	}
}
