package LeetCode;
import java.util.*;


public class q15_3sum {

	public static void main(String[] args) {
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		threeSum(nums);
	}
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length < 3)
            return res;
        
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hashset= new HashSet<ArrayList<Integer>>();
        
        for(int i = 0; i< nums.length; i++) {
            int low = i+1;
            int high = nums.length -1;
            
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                
                if(sum == 0) {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    array.add(nums[i]);
                    array.add(nums[low]);
                    array.add(nums[high]);
                    
                    if(!hashset.contains(array)) {
                        hashset.add(array);
                        res.add(array);
                        System.out.println(array.toString());
                    }
                    
                 low ++;
                 high --;
                    
                } else if ( sum > 0) {
                    high --;
                } else {
                    low ++;
                }
            }
        }
        return res;
    }
}
