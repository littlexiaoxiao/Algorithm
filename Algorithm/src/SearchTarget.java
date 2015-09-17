
public class SearchTarget {
	//a sorted array
	//find the first position whose value equals target;
	
	public static int searchTarget(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length -1;
		
		int res = -1;
		while(left + 1 < right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target) {
				left = mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if(target == nums[right])
			return right;
		
		if(target == nums[left]) {
			return left;
		}
		
		
		
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,4,5,6};
		int res = searchTarget(nums, 1);
		System.out.println("res = " + res);
	}

}
