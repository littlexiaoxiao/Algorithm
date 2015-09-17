package LeetCode;
public class move_column {

	public static void move(int[] nums, int target, int position) {
		if (nums == null || nums.length == 0 || target >= nums.length
				|| target < 0 || position >= nums.length || position < 0
				|| target == position) {
			return;
		}
		int temp = nums[target];
		if (position < target) {
			for (int i = target; i > position; i--) {
				nums[i] = nums[i - 1];
			}
			nums[position] = temp;
			return;
		}

		if (position > target) {
			for (int i = target; i <= position; i++) {
				nums[i] = nums[i + 1];
			}
			nums[position] = temp;
			return;
		}

	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6 };
		move(nums, 4, 2);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		// TODO Auto-generated method stub

	}

}
