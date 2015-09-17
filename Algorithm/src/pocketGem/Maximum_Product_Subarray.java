package pocketGem;

public class Maximum_Product_Subarray {
//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length ==0)
			return 0;
		
		int global_max = nums[0];
		int local_max = nums[0];
		int local_min = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int local_max_copy = local_max;
			local_max = Math.max(Math.max(nums[0] * local_max, nums[i]), local_min * nums[i]);
			local_min = Math.min(Math.min(local_min * nums[i], nums[i]), local_max_copy * nums[i]);
			global_max = Math.max(global_max, local_max);
		}
		return global_max;
	}

}
