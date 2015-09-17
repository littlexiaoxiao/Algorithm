package booking;

public class FindTargetSum {

	public static void main(String[] args) {
		
		int[] nums = {2,3,1,2,3,4,5};
		findTarget(nums, 5);

	}
	
	public static int[] findTarget(int nums[], int target) {
		int[] res = new int[2];
		
		for(int i = 0; i< nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					res[0] = nums[i];
					System.out.println(res[0]);
					res[1] = nums[j];
					System.out.println(res[1]);
					return res;
				}
			}
		}
		return res;
	}
}
