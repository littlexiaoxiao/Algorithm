package Other_Interviews;

public class Recur {
    public static int recur(int[] nums, int n) {
    	int t;
    	if(n == 1) {
    		return nums[0];
    	} else {
    		t = recur(nums, n-1);
    		if(nums[n-1] > t) {
    			return nums[n-1];
    		} else {
    			return t;
    		}
    	}
    }
	public static void main(String[] args) {
		int[] nums = {1,3,56,86,9};
		System.out.println(recur(nums, 5));
		for(int i : nums) {
			System.out.print(i + ", ");
		}
	}

}
