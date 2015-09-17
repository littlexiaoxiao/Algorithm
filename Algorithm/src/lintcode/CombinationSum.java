package lintcode;
import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;
            
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, candidates, target, 0);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int[] candidates, int target, int start) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            //System.out.println("res item : " + item.toString());
            return;
        }
        
        for(int i = 0; i < candidates.length; i++) {
        	if(i >= start) {
        		item.add(candidates[i]);
        		helper(res, item, candidates, target - candidates[i], i);        		
        		item.remove(item.size()-1);  
        	}
        }
    }
    
	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		combinationSum(nums, 7);
	}
}
