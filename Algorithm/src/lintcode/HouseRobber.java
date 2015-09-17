package lintcode;

public class HouseRobber {
    public static long houseRobber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
            
        if(nums.length == 1) 
            return nums[0];
            
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < dp.length; i++) {
            dp[i] =  Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return (long) dp[nums.length];
    }
	public static void main(String[] args) {
		int[] nums = {5, 16, 1,1, 12,1,1};
		System.out.println(houseRobber(nums));

	}

}
