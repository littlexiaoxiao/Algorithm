package lintcode;

import java.util.ArrayList;

public class Product_of_Array_Exclude_Itself {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		ArrayList<Long> res = productExcludeItself(nums);
		for(long a : res) {
			System.out.print(a + ", ");
		}
	}
	
    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> nums) {
        ArrayList<Long> res = new ArrayList<Long>();
        if(nums == null || nums.size() == 0)
            return res;
        
        if(nums.size() == 1) {
            long a = 1;
            res.add(a);
            return res;
        }
        
        for(int i = 0; i < nums.size(); i++) {
           res.add(findvalue(i, nums));
        }
        return res;
    }
    
    private static long findvalue(int index, ArrayList<Integer> nums) {
        long res = 1;
        for(int i = 0; i < nums.size(); i++) {
            if(i != index) {
            	res = res * nums.get(i);
            	//System.out.print(res + ", ");
            }            
        }
        return (long)res;
    }
}
