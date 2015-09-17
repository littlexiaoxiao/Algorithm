import java.util.ArrayList;
import java.util.List;

public class q131_Palindrome_Partitioning {
	public static void main(String[] args) {
		partition("aaa");
	}

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if(s == null || s.length() == 0) 
            return res;
        
        List<String> item = new ArrayList<String>();
        helper(res, item, s, 0);
        return res;
    }
    
    private static void helper(List<List<String>> res, List<String> item, String s, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<String>(item));
            System.out.println(item);
            return;
        }
        
        for(int i =start; i< s.length(); i++){
            String str = s.substring(start, i+1);
            if(isPalindrome(str)) {
                item.add(str);
                helper(res, item, s, i+1);
                item.remove(item.size() - 1);
            }            
        }        
    }
    
    private static boolean isPalindrome(String str) {
        if(str == null || str.length() == 0)
            return false;
        
        int low = 0;
        int high = str.length() -1;
        while(low < high) {
            if(str.charAt(low) != str.charAt(high))
                return false;
                
            high --;
            low ++;
        }
        return true;
    }
}
