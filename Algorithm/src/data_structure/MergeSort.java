package data_structure;

public class MergeSort {
	public static void mergeSort(int[] nums) {
		int[] temp = new int[nums.length];
		mergeSort(nums, temp, 0, nums.length - 1);
	}
	
	private static void mergeSort(int[] nums, int[] temp, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(nums, temp, left, mid);
			mergeSort(nums, temp, mid+1, right);
			merge(nums, temp, left, mid+1, right);
		}
	}
	
	private static void merge(int[] nums, int[] temp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		while(left <= leftEnd && right <= rightEnd) {
			if(nums[left] <= nums[right]) {
				temp[k++] = nums[left++];				
			} else {
				temp[k++] = nums[right++];
			}
		}
		
		while(left <= leftEnd) {
			temp[k++] = nums[left++];
		}
		
		while(right <= rightEnd) {
			temp[k++] = nums[right++];
		}
		
		for(int i = 0; i < num; i++, rightEnd--){
			nums[rightEnd] = temp[rightEnd];
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {111,4,5,7,23,789,1,20};
		mergeSort(nums);
		for(Integer num : nums) {
			System.out.print(num + ", ");
		}
	}

}
