package lintcode;

public class Single_Number {

	public static void main(String[] args) {
		int[] nums = {1,4,3,2,3,4,2};
		int res = singleNumber(nums);
		System.out.println("final res : " + res);
	}
	
	public static int singleNumber(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        
        int res= nums[0];
        for(int i = 1; i < nums.length; i++) {
        	//System.out.println( res + " ^ " + nums[i] + " = "  + (res ^ nums[i]));
            res = res ^ nums[i];
            
        }
        return res;
	}

}
