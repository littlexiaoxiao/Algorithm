package LeetCode;
import java.util.ArrayList;
import java.util.HashSet;


public class q18_4sum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        
        for(int i =0; i< nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int low = j+1;
                int high = nums.length - 1;
                
                while(low < high) {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                   
                    if(sum == target) {
                        array.add(nums[i]);
                        array.add(nums[j]);
                        array.add(nums[low]);
                        array.add(nums[high]);
                        
                        if(!set.contains(array)) {
                            set.add(array);
                            res.add(array);
                            System.out.println(array.toString());
                        }
                    } else if(sum > target) {
                        high --;
                    } else {
                        low ++;
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args){
 		int[] nums = {-3,1,0,4,-1,3,10,-10,2,1,1,1,1,};
 		fourSum(nums, 5);
 	}

}
