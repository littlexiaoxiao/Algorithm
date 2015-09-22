package lintcode;

public class Jump_Game {
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        if(nums.length == 1) {
        	return true;
        }
        
        int jump = 0;
        for(int i = 0; i < nums.length; i++) {
           if(jump >= i && nums[i] + i >= jump) {
               jump = nums[i] + i;
           } 
        }
        return jump >= nums.length-1;
    }
    
	public static void main(String[] args) {
		int[] nums = {2,0,0};
		System.out.println("res = " + canJump(nums));
	}
}
