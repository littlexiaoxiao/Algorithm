package lintcode;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {
	   public static int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0) {
	            return 0;
	        }
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int res = 0;
	        int start = 0;
	        int end = 0;
	        for(int i = 0; i < s.length(); i++) {
	            if(map.containsKey(s.charAt(i))){
	                res = Math.max(res, map.get(s.charAt(i)) - start +1);
	                System.out.println("res= " + res);
	                start = start + 1;
	                map.put(s.charAt(i), i);
	                i = end -1;
	            } else {
	                map.put(s.charAt(i), i);
	                end++;
	            }
	        }
	        res = Math.max(res, end - start);
	        return res;
	    }
    
	public static void main(String[] args) {
		int res = lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz");
		System.out.println("res = " + res);
	}

}
