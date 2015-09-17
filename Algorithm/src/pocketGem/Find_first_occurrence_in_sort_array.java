package pocketGem;
//http://www.1point3acres.com/bbs/thread-130581-1-1.html

public class Find_first_occurrence_in_sort_array {
//	int[] A = [1,2,2,2,3,4,5];
//	int target = 2;
//	target 第一次在A里面出现的index 是1， 所以返回1. 如果target不再A里面，返回-1. 
//	time complexity: O（logn）
	public static int find_First_Occurrence(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid =(left +right) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid -1;
			} else {
				// find the first index
				//have we reached the beginning of the array
				//or middle and it's previous elements are equal?
				//search the left half
				if(mid > 0 && nums[mid] == nums[mid-1]) {
					right = mid -1;
				} else {
					return mid; //we found the first occurence return it
				}
				// find the last index
				
//				if(mid < nums.length-1 && nums[mid] == nums[mid+1]) {
//					left = mid + 1;
//				} else {
//					return mid;
//				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,2,2,2,3,3};
		int res = find_First_Occurrence(nums, 2);
		System.out.println(res);
	}
}