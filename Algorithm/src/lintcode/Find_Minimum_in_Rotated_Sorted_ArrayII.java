package lintcode;

public class Find_Minimum_in_Rotated_Sorted_ArrayII {
	public static int findMin(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] < nums[right])
        	return nums[left];
        
        while(left + 1 < right) {
        	System.out.println(nums[left]);
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid]) {
                left = mid;
            } else if (nums[left] > nums[mid]) {
                right = mid ;
            } else {
               left ++; 
            }
        }
        return nums[right];
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,2,2};
		System.out.println("res = " + findMin(nums));
	}

}
