import java.util.Arrays;


public class q16_3sum_closest {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3 )
            return 0;
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length -1;
            
            while(low < high ) {
                int sum = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(sum - target);
                
                if(diff < min) {
                    min = diff;
                    result = sum;
                }
                    
                if(sum == target) {
                	System.out.println(sum);
                    return sum;
                } else if (sum < target) {
                    low ++;
                } else {
                    high --;
                }
            }
         }
        System.out.println(result);
        return result;
    }
    
    public static void main(String[] args){
		int[] nums = {-3,1,0,4,-1,3,10,-10};
		threeSumClosest(nums, 5);
	}

}
