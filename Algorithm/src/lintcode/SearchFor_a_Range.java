package lintcode;

public class SearchFor_a_Range {
	//give a sorted array (have duplicates)
	//find the range of bound, new int[2], return range;
	public static int[] searchTarget(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return null;
		
		int[] bound = new int[2];
		
		//search for left bounder
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while(left + 1 < right) {
			mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if(nums[left] == target) {
			bound[0] = left;
		} else if (nums[right] == target) {
			bound[0] = right;
		} else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		
		left = 0;
		right = nums.length - 1;
		while(left + 1 < right) {
			mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				left = mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if(nums[right] == target) {
			bound[1] = right;
		} else if (nums[left] == target) {
			bound[1] = left;
		} else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		
		return bound;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,2,2,3,4,5,6};
		int[] res  = searchTarget(nums,2);
		System.out.print("[" + res[0] + ", " + res[1] +"]");
	}

}
