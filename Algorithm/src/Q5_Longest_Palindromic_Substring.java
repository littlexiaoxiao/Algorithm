
public class Q5_Longest_Palindromic_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = longestPalindrome("abbaaaabbbbaaaaa");
		System.out.println(res);
	}

    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return s;
        
        String longest = new String();
        for(int i = 0; i < s.length(); i++){
            String temp1 = Palindromic(s, i, i);
            
            if(temp1.length() > longest.length()) 
                longest = temp1;
                
            String temp2 = Palindromic(s, i, i+1);
            
            if(temp2.length() > longest.length()) 
                longest = temp2;
        }
        return longest;
    }
    
    private static String Palindromic (String str, int start, int end) {
        while(start >=0 && end < str.length() && str.charAt(start) == str.charAt(end)) {           
               start --;
               end ++;
        }
        return str.substring(start+1, end);
    }
}
