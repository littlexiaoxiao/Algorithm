package data_structure;

public class SelectionSort {
// 每一次找到最小 or 最大的元素，把他们归位;
// 时间复杂度 n^2;
	public static void selectionSort(int[] nums) {
		if(nums == null || nums.length ==0)
			return;
	
		for(int i = 0; i < nums.length - 1; i++){
			int index = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[index]) {
					index = j;
				}
			}
			if(index != i) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {234,45,0,1};
		selectionSort(nums);
		for(Integer num : nums) {
			System.out.print(num + ", ");
		}

	}

}
