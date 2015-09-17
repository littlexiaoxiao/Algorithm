import java.util.ArrayList;
import java.util.List;


public class q216_combination_iii {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(k <= 0 || n <= 0 )
            return res;
        
        List<Integer> item = new ArrayList<Integer>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        helper(res, item, k, n, candidates, 0);
        System.out.println(res);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int k, int n, int[] candidates, int start) {
        if(n < 0)
            return;
        
        if(n == 0) {
            if(item.size() == k) {
                res.add(new ArrayList<Integer>(item));
                System.out.println(item.toString());           
            	return;
            }
        }
        
        for(int i = start; i< candidates.length; i++) {
            item.add(candidates[i]);
            int newN = n - candidates[i];
            helper(res, item, k, newN, candidates, i+1);
            item.remove(item.size()-1);
        }
    }
    
	public static void main(String[] args) {
		combinationSum3(2, 10);
	}

}
