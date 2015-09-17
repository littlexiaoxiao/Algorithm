package lintcode;

import java.util.*;

public class PermutationsII {
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0 ){
           return res; 
        }
        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(res, item, nums, visited);
        return res;
    }
    
    private static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item, ArrayList<Integer> nums, boolean[] visited) {
    	//System.out.println("outside: " + item.toString());
        if(item.size() == nums.size()) {
        	System.out.println(item.toString());
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i < nums.size(); i++) {
        	if(i > 0 && nums.get(i) == nums.get(i-1) && visited[i-1]) {
        		continue;
        	}
        	
            if(!visited[i]) {
                item.add(nums.get(i));
                visited[i] = true;
                helper(res, item, nums, visited);
                visited[i] = false;
                item.remove(item.size()-1);
            }           
        }
    }
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(3);
		nums.add(0);
		nums.add(3);
		ArrayList<ArrayList<Integer>> res = permuteUnique(nums);

	}

}
