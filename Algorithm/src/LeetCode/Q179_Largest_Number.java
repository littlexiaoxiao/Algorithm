package LeetCode;
import java.util.*;


public class Q179_Largest_Number {

	public static void main(String[] args) {
		int[] nums = {0, 0};
		String res = largestNumber(nums);
		System.out.println(res);
	}

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        
        String[] strs = new String[nums.length];
        for(int i  =0; i< nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
          
        StringBuilder res = new StringBuilder();
        Comparator<String> cmp = new CompareSring();
        Arrays.sort(strs, cmp); //升序
        for(int i = nums.length-1; i >= 0; i--) {
            res.append(strs[i]);
        }

        if(res.charAt(0) == '0')
        	return "0";
       
        return res.toString();
    }
}    
    class CompareSring implements Comparator<String> {
        public int compare(String a, String b) {
             String temp1 = a + b;
             String temp2 = b + a;
             return temp1.compareTo(temp2);            
        }
    }

