package lintcode;

import java.util.ArrayList;

public class Continuous_Subarray_Sum {
	public static ArrayList<Integer> continuousSubarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length ==0)
            return res;
        
       res.add(-1);
       res.add(-1);
       
       int global_max = Integer.MIN_VALUE;
       int local_max =  Integer.MIN_VALUE;
       int local_count = 0;
       int start= 0;
       int end = 0;
       for(int i = 0; i < nums.length; i++) {
           local_count += nums[i];
           if(local_count > nums[i]) {
               local_max = Math.max(local_max, local_count);
               end ++;
           } else {
               local_max = Math.max(local_max, nums[i]);
               local_count = nums[i];
               start = i;
               end = i;
           }
           
           if(local_max > global_max) {
        	   res.removeAll(res);
               global_max = local_max;
               res.add(start);
               res.add(end);
           }
       }
       return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {-101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22};
		ArrayList<Integer> list = continuousSubarraySum(nums);
		for(Integer i : list) {
			System.out.print(i + ", ");
		}
	}
}
