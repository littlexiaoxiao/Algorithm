package LeetCode;
import java.util.*;


public class Q47Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		permuteUnique(nums);
	}
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null ||nums.length == 0)
            return res;
            
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.fill(visited, 0);
        helper(res, item,nums,visited);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int[]nums, int[] visited) {
        if(item.size() == nums.length) {
            res.add(new ArrayList<Integer>(item));
            System.out.println(item.toString()); //for test;
            return;
        }
            
        for(int i = 0; i< nums.length; i++) {
            if(i > 0 && visited[i - 1] == 1 && nums[i-1] == nums[i])
                continue;
              
             if(visited[i] == 0) {
                visited[i] = 1;
                item.add(nums[i]);
                helper(res, item, nums,visited);
                item.remove(item.size()-1);
                visited[i]  = 0;
             }
        }
    }}
