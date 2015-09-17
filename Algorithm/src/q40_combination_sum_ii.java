import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q40_combination_sum_ii {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length ==0)
            return res;
        
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, candidates, target, 0);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int[] candidates, int target, int start ) {
        if(target < 0)
            return;
        
        if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            System.out.println(item);
            return;
        }
        
        for(int i = start; i< candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1])
                continue;
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(res,item,candidates, newtarget, i+1);
            //item.remove(item.size()-1);
        }
    }
    
    public static void main(String[] args){
  		int[] nums = {1,2,1,2,2,4,1,2,1};
  		combinationSum2(nums, 6);
  	}
}
