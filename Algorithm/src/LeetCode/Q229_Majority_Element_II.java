package LeetCode;
import java.util.*;


public class Q229_Majority_Element_II {

	public static void main(String[] args) {
		int[] nums = {2,3};
		majorityElement(nums);
	}
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer>  res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;
        
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) {
                count ++;
            } else {
                count = 1;
            }
            
            if(count > nums.length / 3) {           	
            	if(!res.contains(nums[i]))  {
            		System.out.println(nums[i]);
            		res.add(nums[i]);
            	}
             }
        }
        return res;
    }
}
