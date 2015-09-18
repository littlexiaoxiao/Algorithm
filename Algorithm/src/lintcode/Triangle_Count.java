package lintcode;

import java.util.*;

public class Triangle_Count {
	   public static int triangleCount(int[] nums ) {
	        if(nums == null || nums.length == 0) {
	            return 0;
	        }
	        Arrays.sort(nums);
	        int left = 0, right = 0, count = 0;
	        for(int i = nums.length-1; i >= 0; i--){
	            left = 0;
	            right = i-1;
	            while(left < right) {
	                if(nums[left] + nums[right] > nums[i]) {
	                    count += right - left; // key point
	                    right--;
	                } else {
	                    left ++;
	                }
	            }
	        }
	        return count;
	    }
	public static void main(String[] args) {
		int[] nums = {3,4,5,6,7};
		System.out.println(triangleCount(nums));
	}

}
