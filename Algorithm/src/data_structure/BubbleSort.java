package data_structure;

public class BubbleSort {
	public static void bubbleSort(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
	
		for(int i = 0; i < nums.length; i++) {
			for(int j =i+1; j< nums.length; j++) {
				if(nums[j] < nums[i]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,5,7,23,789,1,20};
		bubbleSort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+ ", ");
		}
	}
}
