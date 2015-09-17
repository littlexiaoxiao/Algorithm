package LeetCode;
import java.util.*;


public class Q228_Summary_Ranges {

	public static void main(String[] args) {
		int[] nums = {1,2,3,5,6,7,11,12,14};
		summaryRanges(nums);

	}
	
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
            return res;
        
        StringBuilder sb = new StringBuilder();
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i< nums.length; i++) {
        	if(nums[i] == nums[i-1] + 1) 
        		continue;
        	
        	max = nums[i-1];
        	if(max != min) {
        		sb.append(min).append("->").append(max);
        	} else {
        		sb.append(max);
        	}
        	
        	res.add(sb.toString());
        	System.out.println(sb.toString());
        	min = nums[i];
        	sb = new StringBuilder();
        }
        if(min == nums[nums.length-1]) {
          	sb.append(nums[nums.length-1]);
        } else {
        	sb.append(min).append("->").append(nums[nums.length-1]);
        }
        
        System.out.println(sb);       
        res.add(sb.toString());
        return res;
    }

}
