package lintcode;

import java.util.*;

public class Palindrome_Partitioning {
	   public static List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        if(s == null || s.length() == 0) 
	            return res;
	        
	        ArrayList<String> item = new ArrayList<String>();
	        helper(res, item, s, 0);
	        return res;
	    }
	   
	    private static void helper(List<List<String>> res, ArrayList<String> item, String s, int start){
	        if(start == s.length()) {
	            res.add(new ArrayList<String>(item));
	            return;
	        }
	        
	        for(int i = start; i < s.length(); i++) {
	            if(isPalindrome(s, start, i)){
	                item.add(s.substring(start, i+1));
	                helper(res, item, s, i+1);
	                item.remove(item.size()-1);
	            }
	        }        
	    }
	    
	    private static boolean isPalindrome(String s, int left, int right) {
	        while(left <= right) {
	            if(s.charAt(left) != s.charAt(right)) {
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }
	    
	public static void main(String[] args) {
		List<List<String>> res = partition("aaabbb");
		for(List<String> list : res) {
			System.out.println(list.toString());
		}
	}
}
