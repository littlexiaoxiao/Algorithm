package data_structure;

public class InsertionSort {
	public static void insertSort(int[] nums) {
		if(nums == null || nums.length == 0)
			return;

		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,5,7,23,789,1,20};
		insertSort(nums);
		for(Integer num : nums) {
			System.out.print(num + ", ");
		}
	}

}
