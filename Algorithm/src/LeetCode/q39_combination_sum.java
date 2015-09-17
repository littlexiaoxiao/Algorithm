package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class q39_combination_sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        helper(res, item, candidates, target, 0);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, ArrayList<Integer> item, int[] candidates, int target, int start) {
        if(target < 0)
            return;
        
        if(target == 0) {
            res.add(new ArrayList<Integer> (item));
            System.out.println(item.toString());
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1])
                continue;
            
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(res, item, candidates, newtarget,  i);
            item.remove(item.size() - 1);
        }
    }
    
    public static void main(String[] args){
 		int[] nums = {-3,1,0,4,-1,3,10,-10};
 		combinationSum(nums, 5);
 	}
}
