package LeetCode;
import java.util.HashSet;


public class Q3_Longes_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "aab";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
	
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(runner))) {
                if(max < runner - walker)
                    max = runner - walker;
                
                while(s.charAt(walker) != s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker ++;
                }
                walker ++;
                
            } else {
                set.add(s.charAt(runner));
            }
            runner ++;
        }
        
        return Math.max(max, runner- walker);
    }

}
