package lintcode;

public class Remove_Duplicates_from_Sorted_ArrayII {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int count = 2;
		for (int i = 2; i < nums.length; i++) {

			if (nums[i] != nums[count - 2]) {
				nums[count] = nums[i];
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
		return count;
	}

	public static void main(String[] args) {
		// int[] nums =
		// {-1014,-1014,-1014,-1006,-1005,-1004,-1002,-1001,-1000,-999,-999,-998,-997,-997,-997};
		int[] nums = { 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8 };
		System.out.println("res = " + removeDuplicates(nums));

	}

}
